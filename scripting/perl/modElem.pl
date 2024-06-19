#!/bin/perl -w
# bp 238

use strict;

print "\n";
print 'my @array = (68, 101, 114, 111, 117);' . "\n";
print 'my $ref = \@array;' . "\n";
print '${$ref}[0] = 100;' . "\n";
print "\n";

my @array = (68, 101, 114, 111, 117);
my $ref = \@array;
${$ref}[0] = 100;
print "Array is now: @array\n";

print "\n";
