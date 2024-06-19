#!/bin/perl -w

# bp 118

use strict;

print "\n\n"; 
print 'my %where = (' . "\n";
print '	Gary     => "Dallas",' . "\n";
print '	Lucy     => "Exeter",' . "\n";
print '	Ian      => "Reading",' . "\n";
print '	Samantha => "Oregon"' . "\n";
print ');' . "\n";
print "\n"; 
print 'foreach (values %where) {' . "\n";
print '  print "$_ lives in $where{$_}"' . "\n";
print '}' . "\n";
print "\n"; 


my %where = (
	Gary     => "Dallas",
	Lucy     => "Exeter",
	Ian      => "Reading",
	Samantha => "Oregon"
);

foreach (values %where) {
  print "someone lives in $_\n"
}

print "\n"; 
