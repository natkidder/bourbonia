#!/bin/perl -w

# bp 81

use strict;

print "\n";
print "Counting up (1 .. 6) : ", (1 .. 6), "\n";
print "Counting down (6 .. 1) : ", (6 .. 1), "\n";
print "Counting down: reverse(1 .. 6) ", reverse(1 .. 6), "\n";
print "\n";

print "Half the alphabet ('a' .. 'm') : ", ('a' .. 'm'), "\n";
print "The other half (backwards) reverse('n' .. 'z') : ", reverse('n' .. 'z'), "\n";
print "\n";

print "Going from 3 to z reverse(3 .. 'z') : ", reverse(3 .. 'z'), "\n";
print "Going from y to 3 ('y' .. 3) : ", ('z' .. 3), "\n";
print "\n";
