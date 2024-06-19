#!/bin/perl -w

# bp 151
 
use strict;

print "\n";
print '$_ = "Nobody wants to hurt you.. \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'if ($_ =~ /people/) {' . "\n";
print "\n";


$_ = "Nobody wants to hurt you.. 'cept, I do hurt people sometimes, Case.";

if ($_ =~ /people/) {
  print "Hooray!  Found the word 'people'\n";
}
print "\n";
