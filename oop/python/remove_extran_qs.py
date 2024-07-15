import sys
from sys import argv
import os.path
import re

'''
Takes a file that is read by the python qanda.py script and (1) leaves only the first answer and (2) converts the question, clue and answer to CSV cells 
in the same row
'''

## set the destination file
def transform_filename(path):
    pattern = r"(\w+)\.(\w.{2,4})"
    replacement = r"\1.csv"
    path2 = re.sub(pattern,replacement,path)
    return path2
    
def read_write(path, dest_path):
    answer_pttn = re.compile("^a=\w")
    question_pttn = re.compile("^q=\w")
    if not os.path.isfile(path):
        print("file " + path + " does not exist\n")
        return
    else:
        source = open(path, 'r')
        dest = open(dest_path, 'w')
        lines = source.readlines()
        i=0
        prev_line="xxxxx"
        new_line = ""
        for line in lines:
            if question_pttn.match(line):
                new_line = line.rstrip().replace("\"","'").replace(" - ","\",\"").replace("q=","\"",1)+"\"";
                #print("010: " + line + "    " + new_line + "\n") #####
            elif answer_pttn.match(line) and not answer_pttn.match(prev_line):
                another_line = line.rstrip().replace("\"","'").replace(",",",    ").replace("a=","\"",1)+"\"";
                #print("020: " + line) #####
                new_line = new_line + "," + another_line+"\n";
                #print("030: " + new_line) ######
                dest.write(new_line)
            else:
                new_line = "";
            prev_line=line;
        dest.close()
        source.close()
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        src_path = args[0]
        dest_path = transform_filename(args[0])
        read_write(src_path, dest_path)
        print("output in   " + dest_path + "\nIf using Google Sheets, open a new GS document and import that file")
    else:
        print("arg1: source file")
        
