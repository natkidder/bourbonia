#!/bin/perl -w

# bp 75

use strict;

print "\n";
print "loop labels\n";
print 'OUTERLOOP: while ($i <= 5) {' . "\n";
print '    last OUTERLOOP if $j == 3; ' . "\n";
print "\n";

my $i = 1;

OUTERLOOP: while ($i <= 5) {
  my $j = 1;
  while ($j <= 5) {
    last OUTERLOOP if $j == 3; 
    print "$i ** $j = ", $i ** $j, "\n";
    $j++;
  }
  $i++;
}
print "\n";
