#!/bin/perl -w

use strict;

my $refEng = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
my $refFre = ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"];
my $refLang = [$refEng, $refFre];

my ($i, $j);

for $j (0..$#$refEng) {
  foreach $i (0..1) { 
    print $refLang->[$i]->[$j] ;
    if ($i == 0) {
      my $mthLen = 20 - length($refLang->[$i][$j]);
      print " " x $mthLen;
    }
  }
  print "\n";
}

undef $refEng;
