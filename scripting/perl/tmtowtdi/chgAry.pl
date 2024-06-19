#!/bin/perl -w

use strict;

my @ary = (0..4);
my $ref = \@ary;
my $i;

print "before:\n";
print "len ary: " . @ary . "\n";
for $i (@ary) { print $i . "\t"; }
print "\n";
AddOne($ref);
print "\nafter:\n";
print "len ary: " . @ary . "\n";
for $i (@ary) { print $i . "\t"; }
print "\n";
for $i (0..$#ary) { print $ary[$i] . "\t"; }

print "\n";

sub AddOne {
  my $refAry = shift;
  my @ary = @$ref;
  my $len = $#ary;
  foreach my $i (0..$len) {
    print $i . "  " . @$ref[$i] . "\t";
    @$ref[$i] += 1;
    print $i . "  " . @$ref[$i] . "\n";
  }
}
