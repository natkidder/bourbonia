#!/bin/perl -w

# bp 63

use strict;

print "\n" . '$str1 or die "you didn\'t enter a string: ";';
print "\n" . '$str1 and print "you entered \'$str1\'\n";' . "\n\n";

print "enter a string: ";
chomp(my $str1 = <STDIN>);

print "\n";

$str1 or die "you didn't enter a string: ";

$str1 and print "you entered '$str1'\n";

print "\n";
  
