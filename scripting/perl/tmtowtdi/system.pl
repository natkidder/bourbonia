#!/bin/perl -w
# bp 225

use strict;

print "\n";
print 'my $errorStatus = system \'date\';' . "\n";
print "\n";

my $errorStatus = system 'date';

print "system() returned \$errorStatus = $errorStatus\n";

print "\n";
