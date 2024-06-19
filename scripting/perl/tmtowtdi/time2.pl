#!/bin/perl -w
# bp 193

use strict;

print "\n";
print '$| = 1;' . "\n";
print 'foreach (1..20) { print "."; sleep 1; }' . "\n";
print "\n";


$| = 1;
foreach (1..20) {
  print ".";
  sleep 1;
}
print "\n\n";
