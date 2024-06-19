#!/bin/perl -w
# bp 237

use strict;

print "\n";
print 'my @band = qw(Crosby Stills Nash Young);' . "\n";
print 'my $ref = \@band;' . "\n";
print 'foreach (0..$#band) {' . "\n";
print '  print "Array    :", $band[$_] , "\n";' . "\n";
print '  print "Reference:", ${$ref}[$_] , "\n";' . "\n";
print '}' . "\n";
print "\n";

my @band = qw(Crosby Stills Nash Young);
my $ref = \@band;
foreach (0..$#band) {
  print "Array    :", $band[$_] , "\n";
  print "Reference:", ${$ref}[$_] , "\n";
}
print "\n";
