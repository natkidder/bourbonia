#!/bin/perl

##use strict;
use win32::Clipboard;

print "arg1: file to open, arg2: lines from top\n" if scalar(@ARGV) < 2;
my $file = shift;
my $lineCnt = shift;
my $dir = $ENV{PWD};
my $MsgPrtd = 0;
my $line = "";
my $i = 0;
my $CLIP = Win32::Clipboard();

open FI, "<", $dir . "/" . $file;

while (<FI>) {
  $line .= $_;
  $i++;
  last if $i > $lineCnt;
}

print "\nThe following is in the clipboard:\n\n"; 
$CLIP->Set($line);
print "$line\n"; 
$MsgPrtd = 1;

exit 0;
