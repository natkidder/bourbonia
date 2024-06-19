#!/bin/perl -w
# bp 303

use strict;

print "\n";
print 'use Benchmark;' . "\n";
print 'my $howmany = 100;' . "\n";
print 'timethese($howmany, {' . "\n";
print '  line =>  q{' . "\n";
print '             my $file;' . "\n";
print '             open TEST, "words" or die $!;' . "\n";
print '             while (<TEST>) { $file .= $_ }' . "\n";
print '             close TEST;' . "\n";
print '            },' . "\n";
print '  slurp => q{' . "\n";
print '             my $file;' . "\n";
print '             local undef $/;' . "\n";
print '             open TEST, "words" or die $!;' . "\n";
print '             $file = <TEST>;' . "\n";
print '             close TEST;' . "\n";
print '            },' . "\n";
print '  join =>  q{' . "\n";
print '             my $file;' . "\n";
print '             open TEST, "words" or die $!;' . "\n";
print '             $file = join "", <TEST>;' . "\n";
print '             close TEST;' . "\n";
print '            }' . "\n";
print "\n";


use Benchmark;

my $howmany = 100;

timethese($howmany, {
  line =>  q{
             my $file;
             open TEST, "words" or die $!;
             while (<TEST>) { $file .= $_ }
             close TEST;
            },
  slurp => q{
             my $file;
             local undef $/;
             open TEST, "words" or die $!;
             $file = <TEST>;
             close TEST;
            },
  join =>  q{
             my $file;
             open TEST, "words" or die $!;
             $file = join "", <TEST>;
             close TEST;
            }
  }
);

print "\n";
