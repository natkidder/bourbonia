#!/bin/perl -w

# bp 84

use strict;

my $month = 3;

print "\n";
print 'Note: print "Month " . $month+1   does not work.  Use: print "Month ", $month+1    instead';
print "\n";  print "\n";
print "Month # ", $month+1, " is: ";
print qw(
	January	February	March
	April	May		June
	July	August		September
	October	November	December
        )[$month];
print "\n\n"
