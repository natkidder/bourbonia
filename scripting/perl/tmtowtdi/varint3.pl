#!/bin/perl

# bp 45

use strict;

print "\n";
print "note use of prior declared variable in initializing another variable's value\n\n";

print 'my $name = "fred"'."\n";
print 'my $salutation = "Dear $name,"'."\n";

print "\n";

my $name = "fred";
my $salutation = "Dear $name,";
print '$salutation = ' . $salutation, "\n";
print "\n";
