#!/bin/perl -w

# bp 133

use strict;

print "\n\n";
print '   sub total {' . "\n";
print '     $total += $_ foreach @_;' . "\n";
print '   total(111, 107, 105, 114, 69);' . "\n";
print '   total(1..100);' . "\n";
print "\n";

total(111, 107, 105, 114, 69);
total(1..100);
print "\n";

sub total {
  my $total = 0;
  $total += $_ foreach @_;
  print "The total is $total\n";
}
