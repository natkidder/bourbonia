#!/bin/perl 

use strict;
use POSIX;

$| = 0;

if (scalar @ARGV < 2) {
  print "DetchSubset.pl, arg1: first line nbr, arg2: last line nbr\n";
  exit -1;
}

my ($lenLine, $longestLen, @lineAry, $field5, $period, $year, $amt );
my $i = 0;
my $inFile = "c:/nkidder/ongoing/DataReceipts/GermanyMthly/EDF_DETSCB_TEST_QA.xml";
my $outFile = "c:/temp/transfer/suspended/golf.xml";
my $firstLine = shift;
my $lastLine = shift;
if ($firstLine > $lastLine) {
  print "2nd param must be >= 1st param\n";
  exit 1;
}
open(FI, "<", $inFile);
print ("input file is $inFile\n");
open(FO, ">", $outFile);
while (<FI>) {
  $i++;
  if (/\|/) {
   print FO $_ if $i >= $firstLine && $i <= $lastLine; 
  } else {
    print FO $_;    
  }
  print $i . " lines processed \n" if $i % 10_000 == 0;
}

close FI, close FO;
print "output in $outFile\n";

##<?xml version='1.0' encoding='windows-1252' standalone='yes'?>
##<edfl>
##<space>
##<openproductionspace>EDFSWN03P EDF_DETSCB</openproductionspace>
##<options><updateon>True</updateon></options>
##<options><createon>True</createon></options>
##<options> <modifyon>True</modifyon></options>
##<eistransaction2><![CDATA[
##134AC494Z9...|Geldmenge M3 im Euro-Waehrungsgebiet /saisonbereinigt / Veraenderung im Quartal|4|1|131998|14|49100000000|0
##134AC494Z9...|Geldmenge M3 im Euro-Waehrungsgebiet /saisonbereinigt / Veraenderung im Quartal|4|1|141998|14|67800000000|0
##134YX900ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenüber 19 Industrieländern / auf Basis der Verbraucherp|6|1|12004|6|99.8|0
##134YX900ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenüber 19 Industrieländern / auf Basis der Verbraucherp|6|1|92004|6|99.1|0
##134YX900ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenüber 19 Industrieländern / auf Basis der Verbraucherp|6|1|122006|6|100.9|0
##134YX900ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenüber 19 Industrieländern / auf Basis der Verbraucherp|6|1|12007|6|100.8|0
##134YX910ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenueber 49 Laendern / auf Basis der Verbraucherpreise|6|1|31993|6|107.6|0
##134YX910ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenueber 49 Laendern / auf Basis der Verbraucherpreise|6|1|122006|6|98|0
##134YX910ZD...|Indikator der preisl.Wettbewerbsfähigkeit d.deutschen Wirtscgegenueber 49 Laendern / auf Basis der Verbraucherpreise|6|1|12007|6|97.5|0
##]]></eistransaction2>
##<closespace/></space>
##</edfl>

