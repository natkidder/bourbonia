#!/bin/perl -w

# bp 109

use strict;

print "\n\n";
print '   my @unsorted = (1, 2, 11, 24, 3, 36, 40, 4);' . "\n";
print "\n";

my @unsorted = (1, 2, 11, 24, 3, 36, 40, 4);

print '   my @string = sort { $a cmp $b } @unsorted;' . "\n";
print "\n";
my @string = sort { $a cmp $b } @unsorted;
print "String sort:  @string\n";
print "\n";

print '   my @number = sort { $a <=> $b } @unsorted;' . "\n";
print "\n";
my @number = sort { $a <=> $b } @unsorted;
print "Numeric sort: @number\n";
print "\n";

