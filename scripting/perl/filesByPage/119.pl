#!/bin/perl -w

# bp 119

use strict;

print "\n\n"; 
print 'my %where = (' . "\n";
print '	Gary     => "Dallas",' . "\n";
print '	Lucy     => "Exeter",' . "\n";
print '	Ian      => "Reading",' . "\n";
print '	Samantha => "Oregon"' . "\n";
print ');' . "\n";
print "\n"; 
print 'my($k, $v);' . "\n";
print 'while (($k, $v) = each %where) {' . "\n";
print '  print "$k lives in $v\n";' . "\n";
print '}' . "\n";
print 'while (each %where) {' . "\n";
print '  print "[@_]\n";' . "\n";
print '}' . "\n";
print "\n"; 


my %where = (
	Gary     => "Dallas",
	Lucy     => "Exeter",
	Ian      => "Reading",
	Samantha => "Oregon"
);

my($k, $v);
while (($k, $v) = each %where) {
  print "$k lives in $v\n";
}
while (each %where) {
  print "[@_]\n";
}

print "\n"; 
