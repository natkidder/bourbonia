import sys
from sys import argv
import os.path
import re

## set the destination file
def transform_filename(path):
    pattern = r"(\w+)\.(\w.{2,4})"
    replacement = r"\1_2.\2"
    path2 = re.sub(pattern,replacement,path)
    return path2
    
def read_write(path, dest_path):
    if not os.path.isfile(path):
        print("file " + path + " does not exist\n")
        return
    else:
        source = open(path, 'r')
        dest = open(dest_path, 'w')
        lines = source.readlines()
        i=0
        for line in lines:
            dest.write(line)
        dest.close()
        source.close()
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        src_path = args[0]
        dest_path = transform_filename(args[0])
        read_write(src_path, dest_path)
        print("output in   " + dest_path)
    else:
        print("arg1: source file")
        