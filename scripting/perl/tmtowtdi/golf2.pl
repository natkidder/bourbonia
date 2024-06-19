#!/bin/perl -w

my $str = "ab";
$str =~ s/\./:/g;
print $str, "\n";
my @ary = split /:/, $str ;
for my $chr (@ary) { print $chr, "\n";}
