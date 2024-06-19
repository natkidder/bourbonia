#!/bin/perl -w
# bp 234

use strict;

print "\n";
print 'my @array   = (2, 4, 6, 8, 10);' . "\n";
print 'my $array_r = \@array;' . "\n";
print "\n";
print 'print "This is our dereferenced array: @{$array_r}\n";' . "\n";
print 'foreach (@{$array_r}) {' . "\n";
print '  print "An element: $_\n";' . "\n";
print '}' . "\n";
print 'print "The highest index is: $#{$array_r}\n";' . "\n";
print 'print "This is what the reference looks like: $array_r\n";' . "\n";
print "\n\n";


my @array   = (2, 4, 6, 8, 10);
##my $array_r = \@array;
my $array_r = [2, 4, 6, 8, 10];

print "This is our dereferenced array: @$array_r\n";
foreach (@{$array_r}) {
  print "An element: $_\n";
}
print "The highest index is: $#$array_r\n";
print "This is what the reference looks like: $array_r\n";
print "\n";
