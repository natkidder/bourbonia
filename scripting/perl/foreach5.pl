#!/bin/perl -w

# bp 101

use strict;

print "\n\n";
print 'my @array = (10, 20, 30, 40);' . "\n";
my @array = (10, 20, 30, 40);

print "Before: @array\n";

print "\n";
print 'foreach (@array) {' . "\n";
print '  $_ *= 2;' . "\n";
print "\n";

foreach (@array) {
  $_ *= 2;
}

print "After: @array\n";
print "\n";
