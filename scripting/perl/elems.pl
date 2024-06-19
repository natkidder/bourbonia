#!/bin/perl -w

# bp 103

use strict;

print "\n\n";
print 'my @array = qw:alpha bravo charlie delta:;' . "\n";

my @array = qw:alpha bravo charlie delta:;

print 'print "Scalar value : ", scalar(@array), "\n";' . "\n";
print 'print "Highest index: ", $#array, "\n";' . "\n";
print "\n";

print "Scalar value : ", scalar(@array), "\n";
print "Highest index: ", $#array, "\n";

print "\n";
