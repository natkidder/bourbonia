#!/bin/perl

use strict;
use win32::Clipboard;

my $msg = shift;
my $MsgPrtd = 0;
my $CLIP = Win32::Clipboard();

if (!$msg){ 
  print "Usage: dlymsg.txt <msg fragment>\n"; 
  exit 1; 
}
my $line = "";

open F1, "<", "u:/ongoing/DataReceipts/DlyMsg.txt";

print "\nThe last line is in the clipboard:\n\n"; 
while ($line = <F1>) {
  if ($line =~ /$msg/i) { 
    $CLIP->Set($line);
    print "$line\n"; 
    $MsgPrtd = 1;
  }
}
print "no lines qualify\n" if not $MsgPrtd;

close F1;
exit 0;
