#!/usr/bin/perl
use strict;

##use win32::Clipboard;

##print "arg1: file to open\n" if scalar(@ARGV) < 1;
##my $file = shift;
my $dir;
if (scalar(@ARGV) > 0) {
    $dir = shift;
} else {
    $dir = $ENV{PWD};
}       
##my $CLIP = Win32::Clipboard();

$dir =~ s/\/cygdrive\/c/c:/;
$dir =~ s/\//\\/g;
if ($dir !~ /\\$/)  {
    $dir =~ s/$/\\/;
}

print "$dir";

##$CLIP->Set($dir);

exit 0;
