#!/bin/perl -w

# bp 157

use strict;

print "\n";
print 'my $syllable = "ink";' . "\n";
print 'while (<>) { print if /$syllable$/; } ' . "\n";
print "\n";


my $syllable = "ink";

while (<>) {
  print if /$syllable$/;
}

print "\n";
