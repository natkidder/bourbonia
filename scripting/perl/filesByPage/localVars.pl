#!/bin/perl -w

use strict;

my $a = 0;
my @a = (2, 3, 5, 7, 11);
print "before block: $a\n";

for $a (@a) {
##  $a++;
  print "inside block: $a\n";
}
print "after block: $a\n";
