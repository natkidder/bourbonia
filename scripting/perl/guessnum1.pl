#!/bin/perl

# bp 54

use strict;

print "\nNo need to chomp the varible holding <STDIN>, as it will be cast as numeric\n\n";

my $target = 12;
print "Guess my number!\n";
print "Enter your guess: ";
my $guess = <STDIN>;

if ($target == $guess) {
  print "That's it! You guessed correctly!\n";
  exit(0);
}
if ($guess > $target) {
  print "Your number is more than my number\n";
  exit(1);
}
if ($guess < $target) {
  print "Your number is less than my number\n";
  exit(1);
}
