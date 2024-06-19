#!/bin/perl -w

# bp 114

use strict;

print "\n\n";
print 'my %where = (' . "\n";
print '	Lucy =>    "Exeter",' . "\n";
print "\n";

my %where = (
	Gary =>    "Dallas",
	Lucy =>    "Exeter",
	Ian  =>    "Reading",
	Samanth => "Oregon"
);

print 'delete $where{Lucy};' . "\n";
print 'print "Lucy lives in $where{Lucy}\n";' . "\n";
print "\n";

delete $where{Lucy};
print "Lucy lives in $where{Lucy}\n";
print "\n";
