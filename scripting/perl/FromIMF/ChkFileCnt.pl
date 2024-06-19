#!/bin/perl -w

use strict;
if (scalar @ARGV < 1) {
  print "arg1: APDI PDF file directory, arg2: File Name Regex\n";
  exit 1;
}
my $ifsDir = shift;
my $filenameRegex = shift;
my $file;
my $cnt = 0;
my $prevCnt = 0;
my $loopCnt = 0;
print "needs work\n";

opendir DH, "$ifsDir" or die "couldn't open the current directory: $!";

while (1==1) {
  $cnt = 0;
  while ($_ = readdir(DH)) {
    $file = $_;
    next if $_ eq "." or $_ eq "..";
    if ($_ =~ /$filenameRegex/) {
      $cnt++;
    }
  }
  if ($cnt > $prevCnt and $loopCnt > 0) {
    print "File count for $filenameRegex increased from $prevCnt to $cnt\n";
    last;
  }
  $prevCnt = $cnt;
  $loopCnt++;
  sleep 5;
}
closedir DH;

