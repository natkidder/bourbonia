#!/bin/perl - w

# bp 87

use strict;

my @days;

print "\n";
print '@days = qw@Monday Tuesday Wednesday Thursday Friday Saturday Sunday@;', "\n";
print 'undeclared: $days = 31;' . "\n";
print "\n";

@days = qw@Monday Tuesday Wednesday Thursday Friday Saturday Sunday@;
$days = 31;

print "\n";
