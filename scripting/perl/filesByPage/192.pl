#!/bin/perl -w
# bp 192
# NOTE: it is called sort1.pl in the text, but there's a previous sort1.pl
#       in the same book

use strict;

die "arg1: source file to sort, arg2: dest file" if @ARGV != 2;

my $input = shift;
my $output = shift;

print "\n";
print 'my @file = <INPUT>;' . "\n";
print '@file = sort @file;' . "\n";
print 'print OUTPUT @file;' . "\n";
print "\n";


open(INPUT, '<', $input) or die "Couldn't open file $input: $!\n";
open(OUTPUT, '>', $output) or die "Couldn't open file $output: $!\n";

my @file = <INPUT>;
@file = sort @file;

print OUTPUT @file;

close INPUT; close OUTPUT;  ## BTW, cannot say close(INPUT, OUTPUT)
