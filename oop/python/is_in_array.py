
'''
check to see if an element is in an array
'''

def is_in_array(test_array,test_string):
    if len(list(filter (lambda x : x == test_string, test_array))) > 0:
        return "is in array"
    else:
        return "is not in array"
    
if __name__ == '__main__':
    test_array = []
    test_array.append('Smokey the Bear')
    test_array.append('Woodsey the Owl')
    test_string = 'Smokey the Bear2'
    print(is_in_array(test_array,test_string))