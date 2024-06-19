# Python code to pick a random 
# word from a text file 
import random
import sys 
import re

def transform_filename(path):
    pattern = r"(\w+)\.(\w.{2,4})"
    replacement = r"\1_2.\2"
    path2 = re.sub(pattern,replacement,path)
    return path2

# Open the file in read mode 
def operate_on_file(src_filepath,dst_filepath):
    with open(src_filepath, "r") as file: 
        allText = file.read() 
        words = list(map(str, allText.split())) 
    
        # print random string 
    print(random.choice(words)) 

if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        dest_path = transform_filename(args[0])
        operate_on_file(args[0], dest_path)
        print("output in   " + dest_path)
    else:
        print("arg1: path to file to read\n")
