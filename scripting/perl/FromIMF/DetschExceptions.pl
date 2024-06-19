#!/bin/perl 

use strict;
use POSIX;

$| = 0;

my ($lenLine, $longestLen, @lineAry, $field5, $period, $year, $amt);
my $i = 0;
open(FI, "<", "c:/temp/transfer/suspended/EDF_DETSCB.xml");
print ("input file is c:/temp/transfer/suspended/EDF_DETSCB.xml\n");
open(FO, ">", "c:/temp/transfer/suspended/DETSCB_LongLines.txt");
while (<FI>) {
  $i++;
  if (/\|/) {
    my @lineAry = split q/\|/, $_ ; 
    if (scalar (@lineAry) != 8) {
      print FO "$i:Fields != 8: " . $_;
    }
    if (length($lineAry[0]) < 13 || length($lineAry[0]) > 20) {
      print FO "$i:TS wrong length: " . $_ . "\n";
    }
    if (index("#14#8#6#4#2#", "#" . $lineAry[2] . "#") < 0) {
      print FO "$i:3rd field is : " . $lineAry[2] . "\n";
    }
    if (index("#0#1#2#3#4#6#", "#" . $lineAry[3] . "#") < 0) {
      print FO "$i:4th field is : " . $lineAry[3] . "\n";
    }
    $field5 = $lineAry[4];
    $year = substr($field5,-4, 4);
    $period = substr($field5, 0, length($field5)-4);
    if ($year < 1945 || $year > 2007 || $period < 1 || $period > 17) {
      print FO "$i:5th field is : " . $lineAry[3] . "\n";
    }
    if (index("#14#6#4#", "#" . $lineAry[5] . "#") < 0) {
      print FO "$i:6th field is : " . $lineAry[5] . "\n";
    }
    $amt = $lineAry[6];
    if (  $amt =~ /[\!\@\#\$\%\^\&\*\(\)\_\+\=\{\}\[\]\:\;\"\'a-zA-Z]/ || 
          $amt =~ /.-./  || 
          $amt =~ /\Q..\E/ || 
          $amt =~ /\Q.\E.+\Q.\E/ ) {
      print "i:7th field is : " . $amt . "\n";
    }
    my $fie7 = $lineAry[7]; chomp($fie7);
    if (index("#0#", "#" . $fie7 . "#") < 0) {
      print FO "$i:8th field is : " . $fie7 . "\n";
    }
    
  }
  print $i . " lines processed \n" if $i %10000 == 0;
}

close FI, close FO;
print "output in DETSCB_LongLines.txt\n";

sub FMod
{ 
  my( $a, $b ) = @_;
  if(!$b || ref($b)) # just to be careful
  {
     print "wrong type or division by 0!\n";
     return undef;
  }
  my $q = $a / $b;
  return $a - $b*floor( $q ) ; 
}
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
