#!/bin/perl -w
open(F1, "c:/foo/test.txt") or die("could not open\n");
while(<F1>) {
  if ($_ =~ /$ARGV[0]/) {
    print "$_\n";
  }
}
close(F1);
