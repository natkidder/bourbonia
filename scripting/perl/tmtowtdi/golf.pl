#!/bin/perl

open FH, "<", "runPerl.unx";
open FH2, ">", "runPerl2.unx";
while (<FH>) {
  $_ =~ s/##//;
  print FH2 "## vi " . $_;
  print FH2 "## perl " . $_ , "\n";
}
close FH;
close FH2;
## unlink("runPerl.unx");
## rename("runPer2.unx","runPerl.unx");
