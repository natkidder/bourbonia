#!/bin/perl -w

# bp 89

use strict;

my @array1;
my $scalar1;

print "\n\n";
@array1 = qw{Monday Tuesday Wednesday Thursday Friday Saturday Sunday};
$scalar1 = @array1;
print "Array 1 is @array1\n";
print '$scalar1 = @array1;' . "\n";
print "Scalar 1 is $scalar1\n";
print "\n";

my @array2;
my $scalar2;

print "\n";
@array2 = qw[Winter Spring Summer Autumn];
$scalar2 = @array2;
print "Array 2 is @array2\n";
print '$scalar2 = @array2;' . "\n";
print "Scalar 2 is $scalar2\n";
print "\n";
