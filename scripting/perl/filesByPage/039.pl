#!/bin/perl -w

# bp 39

print "\nYou can also perl -w <file>\n\n";

print "\n";
$a = 6 * 9;
print "six nines (\$a = 6 * 9) are ", $a, "\n";
$a += 3;
print "Plus three (\$a += 3) is ", $a, "\n";
$a /= 3;
print "All over three (\$a /= 3) is ", $a, "\n";
$a += 1;
print "Add one (\$a += 1) is ", $a, "\n";
$a **= 2;
print "square it (\$a **= 2) is ", $a, "\n";
$a /= 8 - 6; 
print "Note the precedence:  \$a /= 8 - 6  gives you; ", $a, "\n";
print "\n";
