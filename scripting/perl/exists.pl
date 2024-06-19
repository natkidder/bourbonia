#!/bin/perl -w

# bp 120

use strict;

print "\n\n"; 
print 'my %where = (' . "\n";
print '	Gary     => "Dallas",' . "\n";
print '	Lucy     => "Exeter",' . "\n";
print '	Ian      => "Reading",' . "\n";
print '	Samantha => "Oregon"' . "\n";
print ');' . "\n";
print 'print "Gary exists in the hash!" if exists $where{Gary};' . "\n";
print "\n"; 

my %where = (
	Gary     => "Dallas",
	Lucy     => "Exeter",
	Ian      => "Reading",
	Samantha => "Oregon"
);

print "Gary exists in the hash!\n" if exists $where{Gary};
print "Larry exists in the hash!\n" if exists $where{Larry};

print "\n\n"; 
print 'my @seasons = qw(Winter Spring Summer Fall);' . "\n";
print 'if ((exists $seasons[3]) && !(exists $seasons[4])) {' . "\n";
print '  print "There are 4 seasons" ' . "\n";
print "\n"; 

my @seasons = qw(Winter Spring Summer Fall);
if ((exists $seasons[3]) && !(exists $seasons[4])) {
  print "There are 4 seasons\n" 
}

print "\n"; 
