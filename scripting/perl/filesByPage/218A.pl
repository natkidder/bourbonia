#!/bin/perl -w
# bp 218

use strict;

print "\n";
print 'opendir DH, "." or die "couldn\'t open the current directory: $!";' . "\n";
print 'while ($_ = readdir(DH)) {' . "\n";
print '  next if $_ eq "." or $_ eq "..";' . "\n";
print '  print $_, " " x (30- length($_));' . "\n";
print '  print "d" if -d $_;' . "\n";
print '  print "r" if -r _;' . "\n";
print "\n";
print "Press <Ent> to Cont: ";  my $cont = <STDIN>;


print "Contents of the current directory:\n";
opendir DH, "." or die "couldn't open the current directory: $!";

while ($_ = readdir(DH)) {
  next if $_ eq "." or $_ eq "..";
  print $_, " " x (30- length($_));
  print "d" if -d $_;
  print "r" if -r _;
  print "w" if -w _;
  print "x" if -x _;
  print "o" if -o _;
  print "\t";
  print -s _ if -r _ and -f _;
  print "\n";
}
closedir DH;

print "\n";
