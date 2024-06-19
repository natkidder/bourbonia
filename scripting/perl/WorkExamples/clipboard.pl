#!/bin/perl -w

#use strict;
use win32::Clipboard;

my $CLIP = Win32::Clipboard();
print "Clipboard contains: ", $CLIP->Get(), "\n";
$CLIP->Set("some text to copy into the clipboard");
$CLIP->Empty();
$CLIP->WaitForChange();
print "Clipboard has changed!\n";
