#!/bin/perl -w

# bp 100

use strict;

my @array = (1, 3, 5, 7, 9);

print "\n\n";
print 'foreach my $i (@array) {' . "\n\n";
foreach my $i (@array) {
  print "odd nbr: $i\n";
}
print "\n";
