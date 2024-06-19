#!/bin/perl -w

open(F1, "//EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") or die("could not open\n");
open(F2, ">c:/foo/golf.txt");
$MatchStr = $ARGV[0];
print $MatchStr . "\n";  ######
while($line = <F1>) 
{ $LineNbr++;
  if ($line =~ m/Case ID+/) {
    $CaseID = $line;
    $CaseID = substr($CaseID,length($CaseID)-8,6);
  }
  $LineAll = $line2 . " " . $line;
  if ($LineAll =~ /$MatchStr/i) {
    print F2 "Case " . $CaseID . "\n";
    print F2 $LineNbr . ": $LineAll\n";
  }
  $line2 = $line;
}
close(F2);
close(F1);
system("c:/nkidder/lemmy/vi.exe c:/foo/golf.txt")
