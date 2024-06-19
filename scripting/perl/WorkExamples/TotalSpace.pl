#!/bin/perl -w 

# ASSUMES the size of a file is the first true number after the 25th position
# of ls -l

use strict;

my $foo = "";
my $ll = $ARGV[0]; 
my $filesize = 0;
my $file = "";
my $cumsize = 0;
my $line = "";
my $dimLine = "";
my @scale = ("KB","MB","GB");
my $i = 0;

if (!$ll) { 
  print "arg0: files to evaluate\n";
  exit(1);
}
else {
  print "Ensure you hard-quoted or escaped wildcards\nPress <Ent> to Cont: ";
}
$foo = <STDIN>;

$ll = "ls -l " . $ll . " > c:/foo/golf.txt";

system("$ll");
#system("c:/nkidder/vi.exe c:/foo/golf.txt");  ####
open(F1, "<c:/foo/golf.txt");
while ($line = <F1>) {
  if (length($line) > 25) {
  $dimLine = substr($line,25,length($line)-25);
    if ( $dimLine =~ /(\s[0-9]+\s)/ ) {
#      print "\n\$line is: $line\n";     ####
#      print "\$1: $1\n\n" if defined $1;     ####
      print substr($dimLine,1,20) . ": " . $1 . "\n";
      $filesize = $1;
      $cumsize += $filesize
    }
  }
}
$cumsize /= 1000;
while ($cumsize > 1000) {
  $cumsize /= 1000;
  $i++;
}
print "\nTotal size of $ARGV[0] is $cumsize " . $scale[$i] . "\n\n"
