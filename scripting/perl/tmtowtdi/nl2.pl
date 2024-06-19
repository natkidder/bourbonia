#!/bin/perl -w

# bp 181

use strict;

print "\n";
print 'while (<>) {' . "\n";
print '  print $lineno++;' . "\n";
print '  print ": $_";' . "\n";
print '}' . "\n";
print "\n";


my $lineno = 1;

while (<>) {
  print $lineno++;
  print ": $_";
}

