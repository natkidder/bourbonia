#!/bin/perl -w
# bp 214

use strict;

print "\n";
print 'my $prog = shift @ARGV;' . "\n";
print 'die "usage: perl whereIs.pl <file>" unless defined $prog;' . "\n";
print 'foreach my $dir (split /:/, $ENV{PATH}) {' . "\n";
print '  if (-x "$dir/$prog") {' . "\n";
print "\n";


my $prog = shift @ARGV;
die "usage: perl whereIs.pl <file>" unless defined $prog;

my $found = 0;

foreach my $dir (split /:/, $ENV{PATH}) {
  if (-x "$dir/$prog") {
    print "$dir/$prog\n";
    $found = 1;
    last;
  }
}

print "$prog not found in PATH\n" unless $found;

print "\n";
