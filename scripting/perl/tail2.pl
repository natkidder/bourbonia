#!/bin/perl -w
# bp 189

use strict;

print "\n";
print 'my @speech = <FILE>;  ## slurp the entire file into an array' . "\n";
print 'print "Last 5 lines:\n", @speech[-5..-1];' . "\n";
print "\n";


open(FILE, '<', 'gettysburg.txt') or die $!;
my @speech = <FILE>;  ## slurp the entire file into an array
close FILE;

print "Last 5 lines:\n", @speech[-5..-1];

print "\n";
