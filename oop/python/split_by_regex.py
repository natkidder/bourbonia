import re
import string

s_nums = 'one1two22three333four'
print(re.split(r'\d+', s_nums))
# ['one', 'two', 'three', 'four']

print(re.split(r'\d+', s_nums, 2))
# ['one', 'two', 'three333four']

code='$scope.firstname = "John";'
words = re.split(r'[^\w$]',code)
words = list(filter(lambda sp: sp != '',words))
print(words)