#!/bin/perl -w
use File::Path;  
use strict;

my $url = "";  
print $#ARGV . "\n";
if ($#ARGV == -1) {
  $url="http://www.imf.org";
}
else {
  $url = "$ARGV[0]";  
  if (length($ARGV[1]) > 0 && $ARGV[1] ne "&") {
    print "length(argv-1) is " . length($ARGV[1]). "\n"; ####
    $url = $url;
  }
  else {
    unless ($url =~ /\.com|\.net|\.org/i) {
      print "$url: no dot-extension\n";
      $url = $url . ".com";
    }
    unless ($url =~ /www*/) {
      $url = "www." . $url;
    }
    unless ($url =~ /htt*/) {
      $url = "http://" . $url;
    }
  }
}
print "url=$url\n";

system("'C:/Program Files/Internet Explorer/IEXPLORE.EXE' $url &")

