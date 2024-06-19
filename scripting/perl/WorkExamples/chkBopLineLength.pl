#!/bin/perl -w

use strict;

my $line = "";
my $lineLen = 0;
my $i = 0;
my $chkLineLen = 162;

open F1, <, "//edfswn01p/eroot/ip/test/bop.new"
while ($line = <F1>) {
  $i++;
  $lineLen = length($line);
  if ($lineLen <> $chkLineLen) {
    print "At line $i, length is $lineLen\n"
  }
}
close F1
