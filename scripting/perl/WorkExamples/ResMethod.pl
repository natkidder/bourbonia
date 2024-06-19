#!/bin/perl

use strict;
use win32::Clipboard;

my $keyword;
my $keywPrtd = 0;
my $doc = "u:/Ongoing/ProdSupp/ResolutionKeywords.txt";
my $CLIP = Win32::Clipboard();
my $literal = 0;

while (@ARGV) {
  $keyword .= " " . shift;
}
if ($keyword =~ /xx$/) {
  $keyword =~ s/ xx//;
  $literal = 1;
}
$keyword =~ s/ //;  ## remove leading space

if (!$keyword) { 
  print "Usage: $0 <keyword fragment (spaces allowed)>, end with xx if literal\n"; 
  exit 1; 
}
my $line = "";

print "\nEdit document: vi $doc\n";

open F1, "<", "$doc";

print "\n"; 
print "\nThe last line is in the clipboard:\n\n"; 
if ($literal) {
  $keyword = '^' . $keyword;
  $keyword .= '$';
}
while ($line = <F1>) {
  chomp($line); chop($line);
  if ($line =~ /$keyword/i) { 
    $CLIP->Set($line);
    print "$line\n"; 
    $keywPrtd = 1;
  }
} 
print "no lines qualify\n" if not $keywPrtd;

close F1;
exit 0;
