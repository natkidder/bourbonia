#!/bin/perl -w

# bp 179

use strict;

print "\n";
print 'open(FH, \'<\', \'GoodOpen.dat\') or die $!;' . "\n";
print "\n";


open(FH, '<', 'GoodOpen.dat') or die $!;

print "GoodOpen.dat opened successfully\n";

close FH;

print "\n";
