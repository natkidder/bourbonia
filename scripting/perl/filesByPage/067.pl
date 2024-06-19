#!/bin/perl -w

# bp 67

use strict;

print "\nInfinite loop: press ^C or ^D to stop\n\n";
print "press <Enter> to continue";

my $pause = <STDIN>;
my $countdown = 5;

while ($countdown > 0) {
  print "counting down: $countdown\n";
}
