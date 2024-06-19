#!/bin/perl - w

# bp 91

use strict;

my $scalar0;
my $scalar1;
my $scalar2;

print "\n\n";
print 'my @array = (10, 20, 30);' . "\n";
print '($scalar0, $scalar1, $scalar2) = @array;' . "\n";
print "\n";
my @array = (10, 20, 30);
($scalar0, $scalar1, $scalar2) = @array;

print "\$scalar0 is $scalar0\n";
print "\$scalar1 is $scalar1\n";
print "\$scalar2 is $scalar2\n";
print "\n";
