#!/bin/perl -w

# bp 65

use strict;

print "\n";
print "\$_ is the default var to hold std input, but the default arg for print & other functs\n";
print "^D to soft interrupt, ^C to hard interrupt\n\n";
print 'while (<STDIN>) {' . "\n";
print '  print "You Entered: ";' . "\n";
print '  print;' . "\n";
print '}' . "\n\n";

while (<STDIN>) {
  print "You Entered: ";
  print;
}
