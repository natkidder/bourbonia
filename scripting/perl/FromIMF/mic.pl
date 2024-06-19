#!/bin/perl -w

#option strict

my $ConsecBlankLines=0;
my $CaseArg="";
my $i = 0;

if (@ARGV<1) {
  printf "Argument: Array of Case Numbers\n";
  exit;
}

unlink("c:/foo/mic.txt");
open(F2, ">>c:/foo/mic.txt");

foreach $CaseArg (@ARGV) {
  print "CaseArg = $CaseArg\n";  ####
  PrintIndivCase($CaseArg);
  $i++;
  print F2 chr(12) if ($i < scalar(@ARGV));   ####\f;   ####;
}

close(F2);
system("uedit c:/foo/mic.txt");

sub PrintIndivCase {

  $MatchStr = $_[0];
  print "MatchStr = $MatchStr\n";  ####
  open(F1, "//EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") or die("could not open\n");
  $InCase = "False";
  while($line = <F1>) 
  { 
    if ($line =~ m/Case ID+/) {
      if ($line =~ m/$MatchStr/i) {
        $InCase = "True";
      }
      else {
        $InCase = "False";
      }
    }
    if (length($line) == 2) {
      $ConsecBlankLines++;
    }
    else {
      $ConsecBlankLines = 0;
    }
    if (($InCase eq "True") && ($ConsecBlankLines < 5)) {
      print F2 $line;
    }
  }

  close(F1);
##  system("c:/nkidder/lemmy/vi.exe c:/foo/golf.txt")

}
