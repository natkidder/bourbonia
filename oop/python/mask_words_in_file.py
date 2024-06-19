import sys
import os.path
import re
from random import randrange


'''
Takes a file, generally computer code, and randomly changes words (meaning anything between punctuation) and replaces them with
a nonsensical xxxxxxx.  
Thus one can take code that works (such as downloaded from the internet) and replaced with code that won't work - the student must 
now make it work as designed
Not useful for extending code blocks, but good for knowing how code works without having to stare at it or add/remove content
'''

## set the destination file
def transform_filename(path):
    pattern = r"(\w+)\.(\w.{2,4})"
    replacement = r"\1_2.\2"
    path2 = re.sub(pattern,replacement,path)
    return path2
    
'''
randomly set the line numbers to have words replaced.  The number is the total number of lines in the working code times the
percent the user has given.  Set a low percent for beginners, then raise it for more advanced use
'''
def lines_to_target(linecnt, tgt_pct_of_lines):
    tgt_linecnt = linecnt * (tgt_pct_of_lines/100.0)
    tgt_lines = list(())
    # put the randomly-selected lines for which we want to remove words into a list
    i=0
    while i < tgt_linecnt:
        random_line = randrange(linecnt)
        if not random_line in tgt_lines:
            tgt_lines.append(random_line)
            i+=1
    return tgt_lines

'''
Find the number of leading spaces in the source line, so they can be added back to the destination line, to preserve indentation
'''
def pull_leading_spaces(line):
    leading_space_cnt = len(line) - len(line.lstrip())
    leading_spaces = ""
    for i in range(leading_space_cnt):
        leading_spaces += ' '
    #print(line+"    "+str(leading_space_cnt)+"    '"+leading_spaces+"'") ######
    return leading_spaces
    
'''
Taking the list of lines that have to be masked, for each one, pull all of the words, get the count of words, select a random integer within that
count, and then mask that word.  The word is just a sequence of legal variable characters, but can be a value, label or variable name
'''
def mask_words(path, dest_path,pct_of_lines):
    if not os.path.isfile(path):
        print("file " + path + " does not exist\n")
        return
    else:
        source = open(path, 'r')
        dest = open(dest_path, 'w')
        lines = source.readlines()
        tgt_lines=lines_to_target(len(lines),pct_of_lines)
        i=0
        for line in lines:
            i+=1
            line2 = line.rstrip()
            if line2:
                if i in tgt_lines:
                    words = re.split(r'[^\w_$]',line2) # punctuation plus $ or _, the latter is a part of variable names
                    words = list(filter(lambda sp: sp != '',words))  # split leaves a lot of empty strings, remove them
                    #print(line2+"\t"+str(words)) ########
                    words_length = len(words)
                    if (words_length > 0):
                        random_idx = randrange(words_length)
                        word_to_remove = words[random_idx]
                        line2 = pull_leading_spaces(line2) + line2.replace(word_to_remove,'_____')
                dest.write(line2+"\n")                
        dest.close()
        source.close()
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 1:
        #print(args[0]+"   "+args[1]) #######
        dest_path = transform_filename(args[0])
        pct_of_lines = float(args[1])
        mask_words(args[0], dest_path, pct_of_lines)
        print("output in   " + dest_path)
    else:
        print("arg1: path to file    arg2: percent (0-100) of lines to have masking done\n")
