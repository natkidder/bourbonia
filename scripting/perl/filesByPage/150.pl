#!/bin/perl -w

# bp 150

use strict;

my $found = 0;

print "\n";
print '$_ = "Nobody wants to hurt you... \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'chomp(my $sought = <STDIN>);' . "\n";
print 'foreach my $word (split) {' . "\n";
print '  if ($word eq $sought) {' . "\n";
print '    $found = 1;' . "\n";
print '    last;' . "\n";
print '  }' . "\n";
print '}' . "\n";
print "\n";


$_ = "Nobody wants to hurt you... 'cept, I do hurt people sometimes, Case.";

print "Enter the word to test: ";
chomp(my $sought = <STDIN>);

foreach my $word (split) {
  if ($word eq $sought) {
    $found = 1;
    last;
  }
}

if ($found) {
  print "Hooray! found the word '$sought'\n";
} else {
  print "Sorry, did not find the word '$sought'\n";
}
