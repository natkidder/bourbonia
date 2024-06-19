#!/bin/perl -w

# bp 109

use strict;

print "\n\n";
print '   my @unsorted = (1, 2, 11, 24, 3, 36, 40, 4);' . "\n";
print '   my @sorted = sort(@unsorted);' . "\n";
print "\n";

my @unsorted = (1, 2, 11, 24, 3, 36, 40, 4);
my @sorted = sort(@unsorted);
print "Sorted:  @sorted\n";
print "\n";
