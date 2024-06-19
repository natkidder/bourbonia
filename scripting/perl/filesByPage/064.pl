#!/bin/perl -w

# bp 64

use strict;

$| = 0;

my $countdown = 5;

print "\n";
print 'while ($countdown > 0) {' . "\n\n";

while ($countdown > 0) {
  print "counting down: $countdown\n";
  $countdown--;
  sleep 1;
}
print "blastoff!\n\n";
