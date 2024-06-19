import sys
import os.path
import re
from bs4 import BeautifulSoup

'''
pretty-prints an HTML file to another file that is [file prefix]_2.[file_suffix]
'''

def transform_filename(path):
    pattern = r"(\w+)\.(\w.{2,4})"
    replacement = r"\1_2.\2"
    path2 = re.sub(pattern,replacement,path)
    return path2
    
def format_html(path, dest_path):
    if not os.path.isfile(path):
        print("file " + path + " does not exist\n")
        return
    else:
        source = open(path, 'r')
        dest = open(dest_path, 'w')
        lines = source.readlines()
        html = ""
        for line in lines:
            html += line      
        dest.write(BeautifulSoup(html, 'html.parser').prettify()+"\n")
        dest.close()
        source.close()
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        dest_path = transform_filename(args[0])
        format_html(args[0], dest_path)
        print("output in   " + dest_path)
    else:
        print("arg1: path to file\n")