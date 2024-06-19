#!/bin/perl

use strict;
use File::Copy;

my $line = "";
my $PageNbr = 0;

my @pgAnnex = qw/A B C D/;
my ($fileName, @line, @page, $prevPgNbr, $nbrFilesInPg, $pgAnnex);

if (!-e "./filesByPage") {
  mkdir("./filesByPage", 775);
}
system("grep 'bp ' *.pl | grep -v HighPage | grep -v CopyToPageFiles > golf.txt");
open (FI, "< golf.txt") ;
open (FO, "> golf2.txt") ;
while (<FI>) {
  $line = $_;
  @line = split(':', $line);
  $fileName = $line[0];
  @page = split(' ',$line[$#line]);
  $PageNbr = $page[$#page];   
  if ($PageNbr eq $prevPgNbr) {
    $pgAnnex = @pgAnnex[$nbrFilesInPg];
    $nbrFilesInPg++;
  } else {
    $pgAnnex = '';
    $nbrFilesInPg = 0;
  }
  $prevPgNbr = $PageNbr;
  $PageNbr = "0" x (3 - length($PageNbr)) . $PageNbr;
  $PageNbr .= $pgAnnex;

  unlink("./filesByPage/" . $PageNbr . ".pl");
  copy($fileName, "./filesByPage/" . $PageNbr . ".pl");
  chmod("./filesByPage/" . $PageNbr . ".pl", "0777");
##  print FO "cp $fileName      ./filesByPage/$PageNbr" . ".pl\n";
}
print "output in golf2.txt\n";
