#!/bin/perl -w

use strict;

my $path = shift @ARGV;
my $oldStr = shift @ARGV;
my $newStr = shift @ARGV;

$path =~ tr/$oldStr/$newStr/; 

print $path . "\n";
