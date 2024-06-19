import sys
import re
import random

if len(sys.argv) < 2:
	print ("arg1: number of times to play\n")
	sys.exit(1)
iterations = sys.argv[1]

i = int(iterations)
letters='abcdefghijklmnopqrstuvwxyz'
guessltr = ""
givenltr = "x"
while i > 0:
	fwdpos = random.randint(0,25)
	givenltr = letters[fwdpos]
	print("letter is   " + givenltr)
	bwdpos = 25 - fwdpos
	ctrlltr = letters[bwdpos]
	guessltr = input("Enter the reverse letter: ")
	if guessltr == ctrlltr:
		print("correct\n")
	else:
		print("wrong, correct answer is: " + ctrlltr + "\n")
	i -= 1
