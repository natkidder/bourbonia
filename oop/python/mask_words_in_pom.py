import sys
import os.path
import re
import random
from random import randrange

'''
Takes a file, generally computer code, and randomly changes words (meaning anything between punctuation) and replaces them with
a nonsensical _____.  
So for example, 
Thus one can take code that works (such as downloaded from the internet) and replaced with code that won't work - the student must 
now make it work as designed
Good for knowing how code works without having to stare at it or add/remove content, or deal with punctuation
Arguments:
1.  The file to work on
2.  What percent of lines to replace at least some of the words (see argument 1) in.  From 0 to 100
Optional arguments 3 and 4 must be specified together.
  3.  The first line number to start blanking out words.
  4.  The last line number to end blanking out words.
  They are useful if you find only part of the Angular file unfamiliar to you.
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
Unlike with mask words in file, we need to ignore HTML tag lines, otherwise the fixit exercise spends too much time unmasking those
'''
def lines_to_target(lines, tgt_pct_of_lines):
    linecnt = len(lines)
#    tag_pttn = re.compile("^\s*</{0,1}\w+>\s*$")   #HTML tag with only alphanumeric letters between the brackets
#    declare_pttn = re.compile("^\s*<!doctype html>\s*$", re.IGNORECASE)
#    include_pttn = re.compile("^\s*<script\s+.*src=.*>\s*$", re.IGNORECASE)
    comment_pttn = re.compile("^\s*<\!--.*-->\s*$", re.IGNORECASE)
    script_cmmt_pttn = re.compile("^\s*\/\/\s+\S.*\s*$", re.IGNORECASE)
    link_pttn = re.compile("^\s*<link\s+.*rel=.*>\s*$", re.IGNORECASE)
    tgt_domain_lines = list(())
    j=0
    for line in lines:
        line = line.strip()
        j+=1
        #print(line+"    "+str(j)) #######
        if not (comment_pttn.match(line) or link_pttn.match(line) or script_cmmt_pttn.match(line)):
            #print(line) #######
            tgt_domain_lines.append(j)
    tgt_linecnt = len(tgt_domain_lines) * (tgt_pct_of_lines/100.0)
    tgt_lines = list(())
    # put the randomly-selected lines for which we want to remove words into a list
    i=0
    loopcnt = 0
    while i < tgt_linecnt and loopcnt < 1000:
        #print(str(tgt_lines)+"    "+str(tgt_domain_lines)+"    "+str(tgt_linecnt))   ######
        random_line = randrange(linecnt)
        if not random_line in tgt_lines and random_line in tgt_domain_lines:
            #print("adding to random lines")
            tgt_lines.append(random_line)
            i+=1
        loopcnt+=1
    #print("tgt_linecnt="+str(tgt_linecnt)+"    tgt_lines="+str(tgt_lines)+"   tgt_domain_lines="+str(tgt_domain_lines)) #######
    return tgt_lines

'''
Find the number of leading spaces in the source line, so they can be added back to the destination line, to preserve indentation
'''
def pull_leading_spaces(line):
    leading_space_cnt = len(line) - len(line.lstrip())
    #print("'"+line+"'    "+str(leading_space_cnt)) #######
    leading_spaces = ""
    for i in range(leading_space_cnt):
        if i%1 == 0:
            #print(str(i)+"    '"+leading_spaces+"'") #######
            leading_spaces += ' '
    #print(line+"    "+str(leading_space_cnt)+"    '"+leading_spaces+"'") ######
    return leading_spaces
    
'''
Taking the list of lines that have to be masked, for each one, mask each of the html elements 
'''
def mask_words(path, dest_path, pct_of_lines, depth):
    dollar_pttn = re.compile("\$[\w_]+")
    if not os.path.isfile(path):
        print("file " + path + " does not exist\n")
        return
    else:
        source = open(path, 'r')
        dest = open(dest_path, 'w')
        lines = source.readlines()
        tgt_lines=lines_to_target(lines,pct_of_lines)
        i=0
        for line in lines:
            i+=1
            line2 = line.rstrip()
            if line2:
                if i in tgt_lines and depth = line2.count('\t'):
                    line2 = re.sub(r'(</{0,1})(.+?)(>)',r'\1_____\3',line2)
                    #print("line2 020:"+line2) ######
                    #line2 = pull_leading_spaces(line2) + line2
                dest.write(line2+"\n")                
            else:
                dest.write(line)
        dest.close()
        source.close()
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 2:
        dest_path = transform_filename(args[0])
        pct_of_lines = float(args[1])
        beginline = 0
        endline = 9999
        if len(args) > 2:
            beginline = int(args[2])
            endline = int(args[3])
        mask_words(args[0], dest_path, pct_of_lines, depth)
        print("\noutput in   " + dest_path)
    else:
        print("arg1: path to file     arg2: percent (0-100) of lines to have masking done  (optional) arg3 depth of line to blank out\n")
