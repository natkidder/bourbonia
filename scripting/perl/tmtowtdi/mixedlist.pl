#!/bin/perl -w

# bp 79

use strict;

print "\n";
print "in case you were wondering, perl cmds can be broken into different lines eg.\n";
print 'my ' . "\n";
print '$test = 30;' . "\n";
print "is perfectly legal\n";
print "\n";

my 
$test = 30;

print
  "Here is a list containing strings, (this one) ",
  "numbers (",
  3.6,
  ") and variables: ",
  $test,
  "\n"
;
print "\n";
