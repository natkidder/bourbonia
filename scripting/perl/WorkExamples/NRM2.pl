#!/bin/perl -w

my $CaseID="";        ## case number involved
my $LastCaseID="";        ## last case number involved
my $line="";
my $i=0;            ## line counter
my $LineNbr=0;            ## line counter
my $matchCases = "c:/foo/NoResolutionMethod.txt";

$MatchStr = '^Resolution Method :(\s+)$';

open(F1, "< //EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") || die("could not open\n");
open(F3, "> $matchCases");
print F3 "EDF Remedy Cases with no Resolution method: \n";

while($line = <F1>) { 
##  chomp($line); 
  $LineNbr++;
  if ($line =~ m/Case ID+/) {
    $CaseID = $line;
    $CaseID = substr($CaseID,length($CaseID)-8,6);
  }
  $i++;
  if ($MatchStr ne "" && $line =~ /$MatchStr/is) {
    if ($CaseID ne $LastCaseID) {
      print F3 "$CaseID \n";
      $LastCaseID = $CaseID;
    }
  }
  $i = 0;
}
print F3 "\n";
close(F3); 
close(F1);
print "view $matchCases to view all the EDF cases with no resolution method\n";
system("c:/nkidder/lemmy/vi.exe $matchCases");
#system("notepad c:/foo/golf$$.txt") #### RFP
