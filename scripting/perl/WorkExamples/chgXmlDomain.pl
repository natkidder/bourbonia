#!/bin/perl 

use strict;

$| = 0;

if (scalar @ARGV < 4) {
  print "chgXmlDomain.pl, arg1: src svr, arg2: src domain, arg3: target svr, arg4: target domain, arg5: old-, old2-, etc.\n";
  exit -1;
}

my $i = 0;
my $srcSvr = shift;
my $srcDom = shift;
my $tgtSvr = shift;
my $tgtDom = shift;
my $oldNbr = "";
if (defined $ARGV[0]) {
  $oldNbr = shift;
}
my $inFile = "c:/nkidder/ongoing/DataReceipts/GermanyMthly/CompareFiles/$oldNbr$srcDom.xml";
my $outFile = "c:/nkidder/ongoing/DataReceipts/GermanyMthly/CompareFiles/$oldNbr$tgtDom.xml";
my $line;
open(FI, "<", $inFile) or die $!;
print ("input file is $inFile\n");
open(FO, ">", $outFile) or die $!;
while (<FI>) {
  $i++;
  if ( $_ =~ /^<openproductionspace>/i ) {
    print "found svr-domain line\n";
    $_ =~ s/$srcSvr/$tgtSvr/;
    $_ =~ s/$srcDom/$tgtDom/;
  } 
  print FO $_ ;
  print $i . " lines processed \n" if $i % 10_000 == 0;
}

close FI, close FO;
print "output in $outFile\n";

##<openproductionspace>EDFSWN03P EDF_DETSCB</openproductionspace>
