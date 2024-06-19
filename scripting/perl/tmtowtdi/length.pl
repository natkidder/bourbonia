#!/bin/perl -w
# bp 206

use strict;

print "\n";
print '$_ = \'Us and Them\';   ## you CAN assign values to $_' . "\n";
print 'print "length of \'$_\': ", length, "\n";' . "\n";
print "\n";


my $song = 'The Great Gig in the Sky';
print "length of '$song': ", length($song), "\n";
# the 'real' length is 4:44

$_ = 'Us and Them';   ## you CAN assign values to $_
print "length of '$_': ", length, "\n";
# this one is 7:40

print "\n";
