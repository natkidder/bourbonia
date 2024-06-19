#!/bin/perl -w
# bp 237

use strict;

print "\n";
print 'my $ref = \@band;' . "\n";
print 'pop @{$ref};' . "\n";
print "\n";


my @band = qw(Crosby Stills Nash Young);
my $ref = \@band;
print "Band members before: @band\n";
pop @{$ref};
print "Band members after:  @band\n";

print "\n";
