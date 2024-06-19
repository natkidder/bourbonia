#!/bin/perl -w

# bp 179

use strict;

print "\n";
print 'open(FH, \'<\', \'badopen.dat\') or die "We have a problem: $!";' . "\n";
print "\n";

open(FH, '<', 'badopen.dat') or die "We have a problem: $!";

print "Did we make it here?\n";

close FH;

print "\n";
