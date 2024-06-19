#!/bin/perl

use strict;
use win32::Clipboard;

my $msg = shift;
my $MsgPrtd = 0;
my $CLIP = Win32::Clipboard();

##if (!$msg){ 
##  print "Usage: $0 <msg fragment>\n"; 
##  exit 1; 
##}
my $line = '\'Type*\' = "EDF"  AND \'Resolution Method\' = $NULL$';

print "\nThe last line is in the clipboard:\n\n"; 
$CLIP->Set($line);
print "$line\n"; 
$MsgPrtd = 1;

exit 0;
