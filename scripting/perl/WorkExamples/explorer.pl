#!/bin/perl -w
use File::Path;  
use strict;

my $path = "";  
print $#ARGV . "\n";
if ($#ARGV == -1) {
  $path=".";
}
else {
  $path = "$ARGV[0]";  
# TRYING TO SUBSTITUTE BACKSLASHES FOR FORWARD SLASHES
  if ($path =~ /\//i) {
##$value =~ s/\@/&#64;/g;
    $path =~ s/\//\\/g;
  }
}
print "path=$path\n";

system("'c:/windows/explorer.exe' '$path'")
