#!/bin/perl -w

# bp 150

use strict;

my $found = 0;

print "\n";
print '$_ = "Nobody wants to hurt you... \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'my $sought = "people";' . "\n";
print 'foreach my $word (split) {' . "\n";
print '  if ($word eq $sought) {' . "\n";
print '    $found = 1;' . "\n";
print '    last;' . "\n";
print '  }' . "\n";
print '}' . "\n";
print "\n";


$_ = "Nobody wants to hurt you... 'cept, I do hurt people sometimes, Case.";

my $sought = "people";

foreach my $word (split) {
  if ($word eq $sought) {
    $found = 1;
    last;
  }
}

if ($found) {
  print "Hooray! found the word 'people'\n";
}
