#!/bin/perl -w

my @ary = qw/a
b
c
d
/
;

my ($a, $b, $c) = @ary[0..1];
print "$a $b $c\n";
