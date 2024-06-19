import re
import sys

def replace_string(path):
    source = open(path, 'r')
    lines = source.readlines()
    for domain_str in lines:
        print("domain_str='"+domain_str+"'")
        #print(re.split(r'[^\w_\\$]'," this is the $end "))
        words = re.split(r'[^\w_\\$]',domain_str)
        print("words = "+str(words))
        words = list(filter(lambda sp: sp != '',words))
        dollar_pttn = re.compile("\$[\w_]+")
        for k in range(len(words)):
            word_to_remove = words[k]
            if dollar_pttn.match(word_to_remove):
                domain_str = domain_str.replace(word_to_remove,"_____")
            else:
                domain_str = re.sub(r'([^\w_\$])' + word_to_remove + r'(\b[^\w_\$])',r'\1_____\2',domain_str)
            #print("08  "+word_to_remove+"    "+domain_str.replace(word_to_remove,"_____"))
            #print("10  "+word_to_remove+"    "+re.sub(r'([^\w_\$])' + word_to_remove + r'(\b[^\w_\$])',r'\1_____\2',domain_str))
            print("20  "+word_to_remove+"    "+domain_str)
if __name__ == '__main__':
    args = sys.argv[1:]
    if len(args) > 0:
        path = args[0]
        replace_string(path)
    else:
        print("arg1: file to read\n")
