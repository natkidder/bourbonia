#!/bin/perl -w

# bp 73

use strict;

print "\n^d or ^z to exit program\n";
print "'redo' takes you to the top of the loop without testing the condition\n";
print "\n";

my $number = 10;

while (<STDIN>) {
  chomp;
  print "You entered: $_\n";
  if ($_ == $number) {
    $_++;
    redo;
  }
  print "Going to read the next number now...\n";
}
print "\n";
