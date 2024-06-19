#!/bin/perl

# bp 57

use strict;

print "\n" . 'my ($a, $b);' . "\n";
print '$b = 10;' . "\n";
print 'if (defined $a) {' . "\n";
print 'if (defined $b) {' . "\n\n";

my ($a, $b);
$b = 10;

if (defined $a) {
  print "\$a has a value.\n";
}
if (defined $b) {
  print "\$b has a value.\n";
}
print "\n";
