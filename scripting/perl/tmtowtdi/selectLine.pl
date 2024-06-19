#!/bin/perl -w

use strict;

my ($s, @col, @col2, $ref);
@col = split(",","a.fie1, fie2, b.fie3 as alias3, b.fie4");
print "\@col:\n";
for $s (@col) { print $s . "\n"; } ####
$ref = \@col;
@col2 = @{$ref};

##sub LastWord;
##@col2 = LastWord($ref);
LastWord($ref);
print "\@col:\n"; ####
for $s (@col) { print $s . "\n"; } ####

sub LastWord {
  my $aryRef = shift;
  my @ary = @$aryRef;
  my ($i, $elem, $elem2, $elem3);
  print "LastWord: spaces in \@ary:\n";  ####
  for $i (0..$#ary) {
    my @ary2 = split(" ", $ary[$i]);
    $elem2 = $ary2[$#ary2];
    $elem2 =~ s/\./:/g;
    my @ary3 = split(/:/,$elem2);
    $elem2 = $ary3[$#ary3];
    $ary[$i] = $elem2;
  }
#  @ary;
}
