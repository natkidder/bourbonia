#!/bin/perl -w

use strict;

my $outfile = "perlFileContents.txt";
my $line = "";

open(F2,">golf2.unx");
print F2 "rm $outfile\n";
close F2;

open(F1, "command ls *.pl|");
open(F2, ">> golf2.unx");
while (<F1>) {
  $line = $_;   ####
  $line = substr($line,0,length($line)-1);
  print F2 "cat ", $line, " >> $outfile\n";
}
#system("vi golf2.unx"); ####
system("chmod 777 golf2.unx; ./golf2.unx");
print "Output file is $outfile\n";
close F2;
close F1;
