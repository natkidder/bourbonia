#!/bin/perl -w
use File::Path;  

my $dir = "";  
print $#ARGV . "\n";
if ($#ARGV == -1) {
  print "no arguments\n";
}
if ($#ARGV == -1) {
  print "Enter Directory to Make: ";
  chomp($dir = <STDIN>);
}
else {
  $dir = "$ARGV[0]";  
}
print "dir=$dir\n";

mkpath ("$dir") or die "Unable to create directory $dir $!\n"; 

chmod 0777, "$dir ";
