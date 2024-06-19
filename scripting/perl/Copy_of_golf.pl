#!/bin/perl

use strict;

my ($maxlines, $prevLine, $atPage);
my $i = 0;

open FI, "< golf2.txt";
while (<FI>) {
  if ($_ eq $prevLine) {
    $i++;
  } else {
    $i = 1;
  }
  if ($i > $maxlines) {
    $maxlines = $i ;
    $atPage = $_;
  }
  $prevLine = $_;
}
print "The most files on a page is: $maxlines on $atPage\n";
