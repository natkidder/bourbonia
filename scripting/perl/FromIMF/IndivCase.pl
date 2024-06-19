#!/bin/perl -w

#option strict

my $ConsecBlankLines = 0;

open(F1, "//EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") or die("could not open\n");
open(F2, ">c:/foo/golf.txt");
$MatchStr = $ARGV[0];
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
    printf F2 $line;
  }
}
close(F2);
close(F1);
#system("c:/nkidder/lemmy/vi.exe c:/foo/golf.txt")
system("notepad c:/foo/golf.txt")
