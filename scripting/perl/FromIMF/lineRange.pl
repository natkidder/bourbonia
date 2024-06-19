#!/bin/perl -w 

use strict;
use POSIX;

$! = 0;
$| = 0;

if (scalar(@ARGV) < 1) { print "arg1: filename, arg2: lower line, arg3: upper line\n"; exit 1; }
my $filename = shift;
my $lowLine = shift;
my $hiLine = shift;
my $i = 0;

system("wc $filename");
if ($hiLine < $lowLine) { print "arg3 must be >= arg2\n"; exit 1; }
open FI, "< $filename" or die "could not open file $!";
open FO, "> ./LineRange.out";
while (<FI>) {
  $i++;
  if ($i >= $lowLine && $i <= $hiLine) {
    print FO "$i: $_";
    print FO "\n" if FMod($i,10) == 0;
  }
  print $i . "\n" if FMod($i,10000) == 0;
}

close FI, close FO;
print "output in LineRange.out\n";

sub FMod
{ 
  my( $a, $b ) = @_;
  if(!$b || ref($b)) # just to be careful
  {
     print "wrong type or division by 0!\n";
     return undef;
  }
  my $q = $a / $b;
  return $a - $b*floor( $q ) ; 
}
