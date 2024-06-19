#!/bin/perl -w

# bp 115

use strict;

print "\n\n";
print 'my %person = (' . "\n";
print '	name  => \'John Doe\',' . "\n";
print '	age   => 39,' . "\n";
print '	phone => \'555-1212\',' . "\n";
print '	city  => \'Chicago\'' . "\n";
print ');' . "\n";
print '' . "\n";
print 'my @data = %person;' . "\n";
print '' . "\n";
print 'print "list context: ", join("|", @data);' . "\n";
print 'print "another way:  ", %person;' . "\n";
print "\n";

my %person = (
	name  => 'John Doe',
	age   => 39,
	phone => '555-1212',
	city  => 'Chicago'
);

my @data = %person;

print "list context: ", join("|", @data), "\n";
print "another way:  ", %person, "\n";
print "\n";
