#!/bin/perl -w

use strict;

print "\n";
print '@ARGV = qw(file1.dat file2.dat file3.dat);' . "\n";
print 'while (<>) { print "text read : $_ }' . "\n";
print "\n";


@ARGV = qw(file1.dat file2.dat file3.dat);

while (<>) {
  print "text read: $_";
}

print "\n";
