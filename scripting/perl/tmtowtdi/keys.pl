#!/bin/perl -w

# bp 117

use strict;

print "\n\n"; 
print 'my %where = (' . "\n";
print '	Gary     => "Dallas",' . "\n";
print '	Lucy     => "Exeter",' . "\n";
print '	Ian      => "Reading",' . "\n";
print '	Samantha => "Oregon"' . "\n";
print ');' . "\n";
print "\n"; 
print 'foreach (keys %where) {' . "\n";
print '  print "$_ lives in $where{$_}"' . "\n";
print '}' . "\n";
print "\n"; 


my %where = (
	Gary     => "Dallas",
	Lucy     => "Exeter",
	Ian      => "Reading",
	Samantha => "Oregon"
);

foreach (keys %where) {
  print "$_ lives in $where{$_}\n"
}

print "\n"; 
