#!/bin/perl -w
# bp 238

use strict;

print "\n";
print 'my @array = (68, 101, 114, 111, 117);' . "\n";
print 'my $ref = \@array;' . "\n";
print '${$ref}[0] = 100;' . "\n";
print "\n";

##my @array = (68, 101, 114, 111, 117);
my $ref = [68, 101, 114, 111, 117];
$ref->[0] = 100;
print "Array is now: @$ref\n";

print "\n";
