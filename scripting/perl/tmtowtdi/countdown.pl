#!/bin/perl -w

# bp 104

use strict;

print "\n\n";
print'my @count = (1..5);' . "\n";
print 'foreach (reverse(@count)) {' . "\n";
print '  print "$_...\n";' . "\n";
print "\n";

my @count = (1..5);

foreach (reverse(@count)) {
  print "$_...\n";
  sleep 1;
}
print "Blast Off!\n";

print "\n";
