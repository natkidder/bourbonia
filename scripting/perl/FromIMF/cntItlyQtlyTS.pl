#!/bin/perl -w

use strict;

my $susp = $ENV{suspended};
print "$susp\n";
my ($ts, $prevts);
my @line;
my $i = 0;
## for some reason, this will not open the file
##open FI, "< $susp/EDF_ITTSS0Q.xml" or die "Cannot open file";
open FI, "< c:/foo/golf.xml" or die "Cannot open file";
open FO, "> c:/foo/golf.txt" or die "Cannot write to file";
while (<FI>) {
##  print $_, "\n";
  if (!($_ =~ /^</)) {
    @line = split /\|/, $_;
    $ts = $line[0];
    if ($ts ne $prevts) {
      $i++ ;
      print FO $line[4] . "\n";
    }
    $prevts = $ts;
  }
}
print "There are $i Italy Qtly time series\n";
print "output in c:/foo/golf.txt\n";
close FI; close FO;
