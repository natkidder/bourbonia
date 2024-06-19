#!/bin/perl -w

# bp 122

use strict;

print "\n\n"; 
print 'my %where = (' . "\n";
print '	Gary     => "Dallas",' . "\n";
print '	Lucy     => "Exeter",' . "\n";
print '	Ian      => "Reading",' . "\n";
print '	Samantha => "Oregon"' . "\n";
print ');' . "\n";
print "\n"; 
print 'my %who = reverse %where;' . "\n";
print "\n"; 
print 'foreach (keys %who) {' . "\n";
print '  print "$_ lives in $who{$_}"' . "\n";
print '}' . "\n";
print 'my %capitals = qw/Maryland Annapolis Virginia Richmond/;' . "\n";
print 'foreach (keys %capitals) { ' . "\n";
print '  print "$capitals{$_}  is the capital of $_ \n"; ' . "\n";
print '}' . "\n";
print "\n\n"; 

my %where = (
	Gary     => "Dallas",
	Lucy     => "Exeter",
	Ian      => "Reading",
	Samantha => "Oregon"
);

my %who = reverse %where;

foreach (keys %who) {
  print "$_ is where $who{$_} lives \n"
}

my %capitals = qw/Maryland Annapolis Virginia Richmond/;
foreach (keys %capitals) { 
  print "$capitals{$_}  is the capital of $_ \n"; 
}

print "\n"; 
