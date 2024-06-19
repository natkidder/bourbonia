#!/bin/perl -w

my $CaseID="";        ## case number involved
my $LastCaseID="";        ## last case number involved
my $lineAll="";
my $line="";
my $i=0;            ## line counter
my $LineNbr=0;            ## line counter
my $LastMatchLine=0;  ## line number of last match
my $LinesToConcat=0;  ## number of lines to concatenate
my $LinesBuffer=0;    ## so matches don't overlap too much
my $matchLines = "c:/foo/golf$$.txt";
my $matchCases = "c:/nkidder/lemmy/mc.unx";

if ($#ARGV!=1) {
  die("arg1: search string, arg2: lines to check\n");
}
$MatchStr = $ARGV[0];
$LinesToConcat = $ARGV[1];
$LinesBuffer = $LinesToConcat/2;
print "LinesBuffer = $LinesBuffer\n";

print "3/30/07 ia.txt as opposed to iac.txt\n\n"; ####

open(F1, "< //EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") or die("could not open\n");
open(F2, ">$matchLines");
open(F3, ">$matchCases");
print F3 "mc.pl ";

while($line = <F1>) { 
  $LineNbr++;
  if ($line =~ m/Case ID+/) {
    $CaseID = $line;
    $CaseID = substr($CaseID,length($CaseID)-8,6);
  }
# if line is not blank or all whitespace
##  if ($line =~ /\S/) {
    $LineAll = $LineAll . " " . $line;
    $i++;
##  }
  if ($i==$LinesToConcat) {
    if ($MatchStr ne "" && $LineAll =~ /$MatchStr/is && $LineNbr-$LastMatchLine>$LinesToConcat/2) {
      print F2 "\nCase: $CaseID\n";
      print F2 "Line: $LineNbr:\n";
      print F2 " $LineAll\n";  
      $LastMatchLine = $LineNbr;
      if ($CaseID ne $LastCaseID) {
        print F3 "$CaseID ";
        $LastCaseID = $CaseID;
      }
    }
    $LineAll = "";
    $i = 0;
  }
}
print F3 "\n";
close(F3); 
close(F2); 
close(F1);
system("uedit $matchLines");
print "run $matchCases to view all the matching cases\n";
#system("notepad c:/foo/golf$$.txt") #### RFP
