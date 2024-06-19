#!/bin/perl -w

# bp 46

use strict;

print "\n";
print "you may make more readable numeric constant scalars with underscores--perl discards them\n\n";

my $yen = 105.6;   # as of 2 Feb 2004

print '"49,518 yen is ", (49_518/$yen), " dollars' . "\n";
print "\n";
print "49,518 yen is ", (49_518/$yen), " dollars\n";
print "   360 yen is ", (360/$yen), " dollars\n";
print "30,510 yen is ", (30_150/$yen), " dollars\n";
print "\n";
