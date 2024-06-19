#!/bin/perl -w

# bp 108

use strict;

print "\n\n";
my @unsorted = qw'Cohen Clapton Costello Cream Cocteau';
print "Unsorted: @unsorted\n";
print "\n";

print '   my @sorted = sort @unsorted;' . "\n";
print "\n";
my @sorted = sort @unsorted;
print "Sorted:   @sorted\n";   
print "\n";
