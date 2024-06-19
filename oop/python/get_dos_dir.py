import sys
import os.path
import re

'''
Converts a Unix path to a DOS path.
  Args:
    unix_path: The Unix path to convert. (can have spaces"
  Returns:
    The DOS path.
'''

def get_dos_dir(unix_path):
    fullarg = " ".join(unix_path)
    regex = re.compile(r'[/ ]')
    dos_path = regex.sub(r'\\', "/g/My Drive/nat/training/oop/python")
    re.sub(r'^\\([a-zA-Z])',r'\1:','\\g\\My\Drive\\nat\training\\oop\\python')
    return dos_path
    
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        fullarg = " ".join(args)
        #print(get_dos_dir("/g/My Drive/nat/training/oop/python"))
        print('use cygpath -w "<path>" instead')
    else:
        print("arg1: Unix-style path\n")
