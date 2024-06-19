#!/bin/perl -w

# bp 116

use strict;

print "\n\n";
print 'my %person = (' . "\n";
print '	name  => \'John Doe\',' . "\n";
print '	age   => 39,' . "\n";
print '	phone => \'555-1212\',' . "\n";
print '	city  => \'Chicago\'' . "\n";
print ');' . "\n";
print '' . "\n";
print 'my $scalar = %person;' . "\n";
print '' . "\n";
print 'print "scalar context: ", $scalar;' . "\n";
print 'if (%person) {' . "\n";
print '  print "%person has at least one key/value pair\n";' . "\n";
print '} else {' . "\n";
print '  print "%person is empty/n";' . "\n";
print '}' . "\n";
print "\n";

my %person = (
	name  => 'John Doe',
	age   => 39,
	phone => '555-1212',
	city  => 'Chicago'
);

my $scalar = %person;

print "scalar context: ", $scalar, "\n";
if (%person) {
  print "%person has at least one key/value pair\n";
} else {
  print "%person is empty/n";
}
print "\n";
