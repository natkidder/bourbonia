#!/bin/perl -w

# bp 134

use strict;

print "\n\n";
print '   my $sum_of_100 = total(1..100);' . "\n";
print '   sub total {' . "\n";
print '     $total;  ## return value' . "\n";
print "\n";


my $total = total(111, 107, 114, 69);
print "The total is: $total\n";

my $sum_of_100 = total(1..100);
print "The sum of 100 is: $sum_of_100\n";

sub total {
  my $total = 0;
  $total += $_ foreach @_;
  $total;
}
print "\n";
