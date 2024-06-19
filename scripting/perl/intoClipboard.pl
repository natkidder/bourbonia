#!/bin/perl

##use strict;
use win32::Clipboard;

print "arg1: file to open\n" if scalar(@ARGV) < 2;
my $file = shift;
my $dir = $ENV{PWD};
my $MsgPrtd = 0;
my $line = "";
my $i = 0;
my $CLIP = Win32::Clipboard();

open FI, "<", $dir . "/" . $file;

while (<FI>) {
  $line .= $_;
  $i++;
}

print "\nThe following is in the clipboard:\n\n"; 
print "$i lines in all\n";
$CLIP->Set($line);
print "$line\n"; 
$MsgPrtd = 1;

exit 0;
