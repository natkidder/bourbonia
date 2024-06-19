#!/bin/perl -w

use strict;
use win32::Clipboard;

print "arg1: string to transform, arg2: string to replace, arg3: string to substitute\n" if scalar(@ARGV) < 2;
my $str = shift;
my $orig = shift;
my $new = shift;
my $CLIP = Win32::Clipboard();
my $rtn;

$str =~ s/$orig/$new/g;

print "\nThe following is in the clipboard:\n\n"; 
$CLIP->Set($str);
print "$str\n"; 
