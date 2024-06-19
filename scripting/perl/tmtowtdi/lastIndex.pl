#!/bin/perl -w

# bp 95

use strict;

print "\n\n";
print 'my @array = (2, 4, 6, 8);' . "\n";
my @array = (2, 4, 6, 8);

print "The last index, \$#array, is:           ", $#array, "\n";
print "The last element, \$array[\$#array], is: ", $array[$#array], "\n";
my $length = @array;
print "The length is:                         ", $length, "\n";
print "\n";
