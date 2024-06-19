#!/bin/perl -w

# bp 84

use strict;

my $month = -1;

print "\n";
print "Month # ", $month, " is: ";
print qw(
	January	February	March
	April	May		June
	July	August		September
	October	November	December
        )[$month];
print "\n\n"
