#!/bin/perl -w

use strict;

my $CaseID="";        ## case number involved
my $LastCaseID="";        ## last case number involved
my $lineAll="";
my $line="";
my $i=0;            ## line counter
my $LineNbr=0;            ## line counter
my $LastMatchLine=0;  ## line number of last match
my $LinesToConcat=0;  ## number of lines to concatenate
my $LinesBuffer=0;    ## so matches don't overlap too much
my ($MatchArgs, $MatchArg, $MatchStr, @MatchElems, $MatchElem); ## match regular expression parts to match
my $d;  ## delimiter
my $matchLines = "c:/foo/golf$$.txt";
my $matchCases = "c:/nkidder/lemmy/mc.unx";
my @MatchCases; 
my $refMatchCases = \@MatchCases;

if ($#ARGV!=2) {
  die("arg1: search string, arg2: separate strings delimiter, arg3: lines to check\n");
}
$MatchArg = $ARGV[0];
$d = $ARGV[1];
$LinesToConcat = $ARGV[2];
$LinesBuffer = $LinesToConcat/1;
print "LinesBuffer = $LinesBuffer\n";
use subs ("SearchForRegExression");

open(F2, ">$matchLines"); close F2;
open(F3, ">$matchCases"); close F3;

@MatchElems = split($d, $MatchArg);
print "\@MatchElems:\n"; for my $k (@MatchElems) { print "  " . $k . "\n"; }  ####
for $i (0..$#MatchElems) {
  $MatchStr = join(".*", @MatchElems);
  print "\$MatchStr = '$MatchStr'\n";  ####
  SearchForRegExpression($MatchStr);
  $MatchArg = pop(@MatchElems);
  unshift(@MatchElems, $MatchArg);
}

##$MatchStr = $ARGV[0];

sub SearchForRegExpression {
  my $LineAll;
  my $MatchStr = shift;
  open(F1, "< //EDFSWN16P/EDF_Files/EDFDatabases/RemedyTicketFiles/ia.txt") || die("could not open\n");
  open(F2, ">> $matchLines");
  open(F3, ">> $matchCases");
  
  while($line = <F1>) 
  { $LineNbr++;
    if ($line =~ m/Case ID+/) {
      $CaseID = $line;
      $CaseID = substr($CaseID,length($CaseID)-8,6);
    }
    $LineAll = $LineAll . " " . $line;
    $i++;
    if ($i==$LinesToConcat) {
      if ($MatchStr ne "" && $LineAll =~ /$MatchStr/is && $LineNbr-$LastMatchLine>$LinesToConcat/2) {
        print F2 "Case: $CaseID\n";
        print F2 "Line: $LineNbr:\n";
        print F2 " $LineAll\n";  
        $LastMatchLine = $LineNbr;
        if ($CaseID ne $LastCaseID) {
##          print F3 "$CaseID ";
          push @MatchCases, $CaseID;
          $LastCaseID = $CaseID;
        }
      }
      $LineAll = "";
      $i = 0;
    }
  }
  print F3 "\n";
  close(F2); 
  close(F1);
}

my $refMatchCases2 = RemoveDuplicates($refMatchCases);
print F3 "mc.pl ";
for (@{$refMatchCases2}) {
  print F3 "$_ ";
}
close(F3); 

##system("c:/nkidder/lemmy/vi.exe $matchLines");
system("uedit $matchLines &");
print "run $matchCases to view all the matching cases\n";
##system("notepad c:/foo/golf$$.txt") #### RFP

sub RemoveDuplicates {
  my $AryRef = shift;
  my @Ary = sort(@{$AryRef});
  for (@Ary) { print "$_\n"; }  #####
  my $pause = <STDIN>;  ####
  my @Ary2; 
  my $Ary2Ref = \@Ary2;
  my $PrevElem;
  for (@Ary) {
    if ($_ ne $PrevElem) {
      push @Ary2, $_;
    }
    $PrevElem = $_;
  }
  $Ary2Ref;
}
