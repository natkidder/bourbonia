#!/bin/perl -w

# bp 52

use strict;

print "\n";
print "How many-fold a number needs to reach 100\n\n";
print "please enter a number: ";
chomp(my $number = <STDIN>);
my $result = 0;

print 'if ($number != 0) {' . "\n";
print "\n";

if ($number != 0) {
  $result = 100 / $number;
}

print "the result is: $result\n\n";
