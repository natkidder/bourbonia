# import random
import random

# prints a random value from the list
list1 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print(random.choice(list1))

# prints a random item from the string
consonants = "bcdfghklmnpqrstvwxyz"  # j excluded since it's hard as a tailing consonant
vowels = "aeiou"
print(random.choice(consonants))
print(random.choice(vowels))
