#!/bin/perl

use strict;

my $line = "";
my $MaxLine = "";
my $PageNbr = 0;
my $MaxPage = 0;
my @line;

open F1, "-|", "grep 'bp ' *.pl | grep -v HighPage";
##open (F1, system("grep 'bp ' *.pl|");
##open (F1, "< golf.txt") ;
while (<F1>) {
  $line = $_;
##  print "\$line = $line\n";  ####
  @line = split(" ", $line);
  print "  $_ \n" for (@line); ####
  $PageNbr = $line[$#line];   ###pop(@line); 
  $PageNbr += 0;
##  print $line . "\t" . $PageNbr. "\n"; ####
  if ($PageNbr > $MaxPage) {
    $MaxPage = $PageNbr; 
    $MaxLine = $line;
  }
}
print "Highest Page = ", $MaxPage, "\n";
print "Line is: ", $MaxLine, "\n";
