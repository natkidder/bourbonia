#!/bin/perl -w

# bp 181

use strict;

print "\n";
print 'open(FILE, \'<\', \'nlexample.txt\') or die $!;' . "\n";
print 'while (<FILE>) {' . "\n";
print "\n";


open(FILE, '<', 'nlexample.txt') or die $!;
my $lineno = 1;

while (<FILE>) {
  print $lineno++;
  print ": $_";
}

close FILE;
