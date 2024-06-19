#!/bin/perl -w

use strict;

my $instr = <STDIN>;
chomp($instr);

if ($instr =~ /(\s[0-9]+\s)/i) {
  print "$instr\n";
  print "\$1 = $1\n\n" if defined $1;
}
