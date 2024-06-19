#!/bin/perl -w

use strict;

my $line = "";
open F1, "jobs | grep -i dm5|";
while ($line = <F1>) {
  if ($line =~ /dm5.pl/i) {
    print "DM5 is already running\n";
    exit 1;
  }
}
system("C:/WINDOWS/explorer.exe  /e, /n, ::{4577EA30-A1DF-11D0-BA3E-00A024746296}");
close F1;
