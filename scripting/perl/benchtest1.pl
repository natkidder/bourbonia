#!/bin/perl -w
# bp 302

use strict;

print "\n";
print 'use Benchmark;' . "\n";
print 'my $howmany = 10_000;' . "\n";
print 'my $what    = q/my $j=1; foreach (1..100) {$j *= $_}/;' . "\n";
print 'timethis($howmany, $what);' . "\n";
print "\n";


use Benchmark;

my $howmany = 10_000;
my $what    = q/my $j=1; foreach (1..100) {$j *= $_}/;

timethis($howmany, $what);

print "\n";
