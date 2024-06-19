#!/bin/perl -w

# bp 189

use strict;

my @last5;

open (FILE, '<', 'gettysburg.txt') or die $!;

print "\n";
print 'while (<FILE>) {' . "\n";
print '  push @last5, $_;' . "\n";
print '  shift @last5 if @last5 > 5;  ## @array is its length if compared w/ a scalar ?' . "\n";
print '}' . "\n";
print "\n";


while (<FILE>) {
  push @last5, $_;
  shift @last5 if @last5 > 5;  ## @array is its length if compared w/ a scalar ?
}

close FILE;

print "Last five lines:\n", @last5;

print "\n";
