#!/bin/perl -w

# bp 95

use strict;

print "\n\n";
print 'my @array = (2, 4, 6, 8);' . "\n";

my @array = (2, 4, 6, 8);

print "print \@array yields: @array\n";
print "The last index, \$#array, is:\t\t", $#array, "\n";
print "The last element, \$array[\$#array], is:\t", $array[$#array], "\n";

my $length = @array;
print "The length (\$length = \@array) is:\t", $length, "\n";
print "\n";
