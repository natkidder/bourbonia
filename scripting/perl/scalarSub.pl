#!/bin/perl -w

# bp 93

use strict;

print "\n\n";
print 'my @array = (1, 3, 5, 7, 9);' . "\n";
print 'my $subscript = 3;' . "\n";
print 'print $array[$subscript];' . "\n";
print "\n";
my @array = (1, 3, 5, 7, 9);
my $subscript = 3;
print $array[$subscript], "\n";

print "\n";
print '$array[$subscript] = 12;' . "\n";
print "\n";
$array[$subscript] = 12;
print $array[$subscript], "\n";
print "\n";
