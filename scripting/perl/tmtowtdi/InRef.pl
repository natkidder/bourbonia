#!/bin/perl

use strict;

my $line = "";
my $MaxLine = "";
my $PageNbr = 0;
my $MaxPage = 0;
my @line;

system("grep 'bp ' *.pl | grep -v HighPage > golf.txt");
#open (F1, system("grep 'bp ' *.pl|");
open (F1, "< golf.txt") ;
while (<F1>) {
  $line = $_;
  @line = split($line, ' ');
  print "\$line = $line\n";
  print "\@line[0] = @line[0], \$\#line = $#line";  ####
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
