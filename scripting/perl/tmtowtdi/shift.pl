#!/bin/perl -w

# bp 108

use strict;

print "\n\n";

print '  my @array = ();' . "\n";
my @array = ();
print "\n";

print '  unshift @array, "first";' . "\n";
unshift @array, "first";
print "array is now: @array\n";
print "\n";

print '  unshift @array, "second", "third";' . "\n";
unshift @array, "second", "third";
print "Array is now: @array\n";
print "\n";

print '  shift @array;' . "\n";
shift @array;
print "Array is now: @array\n";
print "\n";

