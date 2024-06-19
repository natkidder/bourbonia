#!/bin/perl -w

# bp 74

use strict;

print "\n";
print '  while ($j <= 5) {' . "\n";
print '    last if $j == 3;' . "\n";
print "\n";

my $i = 1;

while ($i <= 5) {
  my $j = 1;
  while ($j <= 5) {
    last if $j == 3;
    print "$i ** $j = ", $i ** $j, "\n";
    $j++;
  }
  $i++;
}
print "\n";
