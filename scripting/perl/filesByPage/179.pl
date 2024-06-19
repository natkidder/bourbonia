#!/bin/perl -w

# bp 179

use strict;

print "\n";
print 'open(FH, \'<\', \'badopen.dat\') or die "We have a problem: $!";' . "\n";
print "\n";

open(FH, '<', 'badopen.dat') or die "We have a problem: $!";

print "We opened badopen.dat, woohoo!\n";

close FH;

print "\n";
