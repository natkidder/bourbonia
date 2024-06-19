#!/bin/perl -w
## takes files of >= a certain number and puts them in an executable

use strict;

my $argv = @ARGV;
if ($argv < 2) {
  print filePart($0) . ", arg1: first file to run, arg2: last file to run\n";
  exit 1;
}
my $firstFileNbr = shift;
my $lastFileNbr = shift; $lastFileNbr++;

open (FI, "-|", "ls [0-9][0-9][0-9]*.pl");
open (FO, "> golf.unx");
while (<FI>) {
  my $fileNbr = substr($_,0,length($_)-3);
##  $fileNbr += 0;
  if ($fileNbr ge $firstFileNbr && $fileNbr le $lastFileNbr) {
    print FO "echo running $_";
    print FO "vi $_";
    print FO "./$_";
    print FO "read -p 'Press Ent to Cont'\n\n";
  }
}
close FI; close FO;
print "output in golf.unx\n";

sub filePart {
  my ($path, @pathAry, $i, $fileName);
  $path = shift(@_);
  @pathAry = split('/', $path);
##  my $fileName = @pathAry($#pathAry);
  for $i (@pathAry) { $fileName = $i; }
  return $fileName;
}
