#!/bin/perl -w

# bp 151
 
use strict;

print "\n";
print '$_ = "Nobody wants to hurt you.. \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'if ($_ =~ /\$regex/) {' . "\n";
print "\n";


$_ = "Nobody wants to hurt you.. 'cept, I do hurt people sometimes, Case.";

print "Enter test regex: ";
chomp(my $regex = <STDIN>);
if ($_ =~ /$regex/) {
  print "Hooray!  Found the word '$regex'\n";
} else {
  print "Sorry,  did not find the word '$regex'\n";
}
print "\n";
