#!/bin/perl -w
# bp 237

use strict;

print "\n";
print 'my $ref = \@band;' . "\n";
print 'my $ref2 = $ref;' . "\n";
print 'pop @{$ref2};' . "\n";
print "\n";


my @band = qw(Crosby Stills Nash Young);
my $ref = \@band;
my $ref2 = $ref;
print "Band members before: @band\n";
pop @{$ref2};
print "Band members after:  @band\n";

print "\n";
