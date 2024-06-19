#!/bin/perl -w

# bp 153

use strict;

print "\n";
print '$_ = "Nobody wants to hurt you... \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'if (/case/) {' . "\n";
print '} else {' . "\n";
print '  print "Case?  Where are you, Case?\n";' . "\n";
print "\n";


$_ = "Nobody wants to hurt you... \'cept, I do hurt people sometimes, Case.";

if (/case/) {
  print "I guess it's just the way I'm made.\n";
} else {
  print "Case?  Where are you, Case?\n";
}

print "\n";
