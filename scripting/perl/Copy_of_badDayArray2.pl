#!/bin/perl - w

# bp 87

use strict;

my @days;
my $days;

print "\n";
print '@days = qw@Monday Tuesday Wednesday Thursday Friday Saturday Sunday@;', "\n";
print 'declared: $days = 31;' . "\n";
print "\n";

@days = qw@Monday Tuesday Wednesday Thursday Friday Saturday Sunday@;
$days = 31;

print "\@days: ", @days, "\n";
print "\$days: ", $days, "\n";

print "\n";
