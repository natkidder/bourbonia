#!/bin/perl

use strict;

my $filename = shift;
print "\$filename: $filename\n"; ####
my $NewFile = "";

if (!$filename) {
  print STDOUT "$0, arg1: Filename\n";
  exit 1;
} elsif (!-e $filename) {
  print STDOUT "file $filename does not exist\n";
  exit 1;
} else {
  $NewFile = $filename;
  $NewFile =~ s/(\s)//g;
}
print STDOUT "\$NewFile = $NewFile\n"; #####
system("mv '$filename' $NewFile");
