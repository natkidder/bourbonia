#!/bin/perl -w

use strict;

my $i;
my @array = qw/1 2 3 4 5/;
my $ref = \@array;
AddOne($ref);
for $i (@array) {
  print $i . "\t";
}

sub AddOne {
  my $ref = shift;
  my $j;
  for $j (@{$ref}) {
    $j++;
  }
}
