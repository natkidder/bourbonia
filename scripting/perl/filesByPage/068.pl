#!/bin/perl -w

# bp 68

use strict;

$| = 0;
my $i;

print "\n  counting backwards from 100 by 7\n\n";
print '  for ($i = 100; $i >= 0; $i-=7) {' . "\n\n";

for ($i = 100; $i >= 0; $i-=7) {
  print $i . "\t";
}
print "\n\n";
