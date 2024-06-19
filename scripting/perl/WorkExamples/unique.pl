#!/bin/perl -w

use strict;

my $line = "";
my $prevline = "";
my $SrcFile = "";
my $DestFile = "";

print "Enter source text file: ";
chomp($SrcFile = <STDIN>); 
print "Enter destination text file: ";
chomp($DestFile = <STDIN>); 

open(F1, "<$SrcFile") || die("could not open $SrcFile\n");
open(F2, ">$DestFile")|| die("could not open $DestFile\n");;
while($line = <F1>) 
{ 
  if ($line ne $prevline) {
    print F2 $line;
  }
  $prevline = $line;
}
close(F2);
close(F1);
system("notepad $DestFile");
