#!/bin/perl -w

# bp 39

print "\n";
$a = 4;
$b = 10;
print "Our variables are \$a: ", $a, " and \$b: ", $b, "\n";
print "\n";
print "\$b = \$a++\n";
$b = $a++;
print "After incrementing, we have \$a: ", $a, " and \$b: ", $b, "\n";
print "\n";
print "\$b = ++\$a * 2\n";
$b = ++$a * 2;
print "Now, we have \$a: ", $a, " and \$b: ", $b, "\n";
print "\n";
print "\$a = --\$b + 4\n";
$a = --$b + 4;
print "Finally, we have \$a: ", $a, " and \$b: ", $b, "\n";
print "\n";
