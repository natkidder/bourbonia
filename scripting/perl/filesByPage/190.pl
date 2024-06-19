#!/bin/perl
# bp 190

use strict;

print @ARGV;  ####
die "arg1: source file, arg2: dest file" if @ARGV != 2;
my $source =      shift @ARGV;
my $destination = shift @ARGV;

open(IN, '<', $source)       or die "Can't read from file $source: $!\n";
open(OUT, '>', $destination) or die "Can't read to file $destination $!\n";

print "\n";
print "Copying $source to $destination\n";
print 'print OUT $_ while (<IN>);' . "\n\n";

print OUT $_ while (<IN>);

close IN; close OUT;
