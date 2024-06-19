#!/bin/perl -w
# bp 266

use strict;

print "\n";
print 'my $a = {};' . "\n";

my $a = {};  ## a hash reference

print '$a is a, ref($a), ', ref($a), " reference\n";

print 'bless($a, "Person1");' . "\n";
bless($a, "Person1");  

print '$a is a, ref($a), ', ref($a), " reference\n";
print "\n";
