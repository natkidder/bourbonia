#!/bin/perl

# bp 49

use strict;

print "\n";
print "Please enter a string to pass to die: ";
chomp(my $string = <STDIN>);
print "\n";

print 'die($string)' . "\n";
print "\n";
die($string);
print "\n";
print "didn't make it this far...\n";
