#!/bin/perl
# bp 30

print "\n";
print "Test one: 6 > 3 && 3 > 4  '", 6 > 3 && 3 > 4 , "'\n";
print "\nkeyword and has lower precedence than other print arguments\n";
print "Test two: 6 > 3 and 3 > 4 '", 6 > 3 and 3 > 4 , "'\n";
print "\n";
print ("Test two: 6 > 3 and 3 > 4 '", 6 > 3) and (3 > 4 , "'\n");
print "\n\n"; 
