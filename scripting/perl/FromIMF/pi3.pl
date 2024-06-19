#!/bin/perl -w

my $line3="";
my $line2="";
my $i=0;            ## line counter
my $LineNbr=0;            ## line counter
my $LastMatchLine=(-2);  ## line number of last match

#open(F1, "c:/foo/piTest.txt") or die("could not open\n");
open(F1, "//EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") or die("could not open\n");
open(F2, ">c:/foo/golf$$.txt");
$MatchStr = $ARGV[0];
print $MatchStr . "\n";  ######
while($line = <F1>) 
{ $LineNbr++;
  if ($line =~ m/Case ID+/) {
    $CaseID = $line;
    $CaseID = substr($CaseID,length($CaseID)-8,6);
  }
  $LineAll = $line3 . " " . $line2 . " " . $line;  ####
  $i++;
  if ($i==2) {
    if ($MatchStr ne "" && $LineAll =~ /$MatchStr/i && $LineNbr-$LastMatchLine>1) {
      print F2 "Case: $CaseID\n";
      print F2 "Line: $LineNbr:\n";
      print F2 " $LineAll\n";  ####
      $LastMatchLine = $LineNbr;
    }
    $i = 0;
  }
  $line3 = $line2;   ####
  $line2 = $line;   ####
}
close(F2);
close(F1);
system("c:/nkidder/lemmy/vi.exe c:/foo/golf$$.txt") #### RFP
