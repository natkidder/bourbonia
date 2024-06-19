#!/bin/perl -w

# bp 152
 
use strict;

print "\n";
print '$_ = "Nobody wants to hurt you.. \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'if (/I do/) {' . "\n";
print "\n";


$_ = "Nobody wants to hurt you.. 'cept, I do hurt people sometimes, Case.";

if (/I do/) {
  print "'I do' is in that string.\n";
}

if (/sometimes Case/) {
  print "'sometimes Case' matched.\n";
}

print "\n";
