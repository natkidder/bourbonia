import sys
import os.path
import re

'''
Takes a file where each section has a question line followed by 1 or more answer lines, followed by a blank space, and 
1. preppends a q= to the question line
2. prepends a a= to each answer line
'''

def transform_filename(path):
    ## example of a backreference
    pattern = r"(\w+)\.(\w.{2,4})"
    replacement = r"\1_2.\2"
    path2 = re.sub(pattern,replacement,path)
    return path2
    
def add_prefixes(path, dest_path):
    if not os.path.isfile(path):
        print("file " + path + " does not exist\n")
        return
    else:
        source = open(path, 'r')
        dest = open(dest_path, 'w')
        lines = source.readlines()
        prevline = ""
        for line in lines:
            line2 = line.strip()
            if line2:
                if not prevline:
                    if not line2.startswith("q="):
                        dest.write("q="+line2+"\n")
                else:
                    if not line2.startswith("a="):
                        dest.write("a="+line2+"\n")
            else:
                dest.write(line2+"\n")
            prevline = line2
        dest.close()
        source.close()
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        dest_path = transform_filename(args[0])
        add_prefixes(args[0], dest_path)
        print("output in   " + dest_path)
    else:
        print("arg1: path to file\n")
