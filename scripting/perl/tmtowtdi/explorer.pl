#!/bin/perl

use strict;

my $path = "";

if ($#ARGV == -1) {
  $path = ".";
}
else {
  $path = @ARGV[0];
  if ($path =~ /\//i) {
    $path =~ s/\//\\/g;
  }
}
print "path = $path\n";   ####

system("'c:/windows/explorer.exe' '$path'");
