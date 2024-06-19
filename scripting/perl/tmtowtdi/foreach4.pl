#!/bin/perl -w

# bp 100

use strict;

print "\n\n";
print 'my @array = (1, 3, 5, 7, 9);' . "\n";
print 'my $i = \'hello there\';' . "\n";
print 'foreach $i (@array) {' . "\n";
print '  print "odd nbr: $i\n";' . "\n";
print '}' . "\n";
print 'print "All done: $i\n";' . "\n";
print "\n";

my @array = (1, 3, 5, 7, 9);
my $i = 'hello there';
foreach $i (@array) {
  print "odd nbr: $i\n";
}
print "All done: $i\n";
print "\n";
