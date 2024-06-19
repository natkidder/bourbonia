#!/bin/perl -w

# bp 91

use strict;

print "\n";
print 'my @array1 = (1, 2, 3);' . "\n";
print '@array2 = (@array1, 4, 5, 6);' . "\n";
print "\n";
my @array1 = (1, 2, 3);
my @array2;
@array2 = (@array1, 4, 5, 6);
print "\@array2: @array2\n";

print "\n";
print '@array2 = (3, 5, 7, 9);' . "\n";
print '@array2 = (1, @array2, 11);' . "\n";
print "\n";
@array2 = (3, 5, 7, 9);
@array2 = (1, @array2, 11);
print "\@array2: @array2\n";
print "\n";
