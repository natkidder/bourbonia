#!/bin/perl -w
# bp 216

use strict;

print "\n";
print 'foreach (<*>) {' . "\n";
print '  next if $_ eq "." or $_ eq "..";' . "\n";
print '  print $_, " " x (30 - length($_));' . "\n";
print '  print "d" if -d $_;' . "\n";
print '  print "r" if -r _;' . "\n";
print "Press <Ent>: ";  my $pause = <STDIN>;


print "Contents of the current directory:\n";

foreach (<*>) {
  next if $_ eq "." or $_ eq "..";
  print $_, " " x (30 - length($_));
  print "d" if -d $_;
  print "r" if -r _;
  print "w" if -w _;
  print "x" if -x _;
  print "o" if -o _;
  print "\t";
  print -s _ if -r _ and -f _;
  print "\n";
}

print "\n";
