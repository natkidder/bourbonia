#!/bin/perl -w

# bp 151

use strict;

print "\n";
print 'my $gibson = "Nobody wants to hurt you... \'cept, I do hurt people sometimes, Case.";' . "\n";
print 'if ($gibson !~ m#fish#) {' . "\n";
print "\n";

my $gibson = "Nobody wants to hurt you... 'cept, I do hurt people sometimes, Case.";

if ($gibson !~ m#fish#) {
  print "There are no fish in William Gibson.\n";
}
print "\n";
