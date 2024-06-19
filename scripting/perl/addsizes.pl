#!/bin/perl -w
# bp 225

use strict;

print "\n";
print 'my @result = `perl directory-dir-nocode.pl`;' . "\n";
print 'foreach (@result) {' . "\n";
print '  if (/^.{30}[drwox]*\t(\d+)$/) {' . "\n";
print '    $size += $1;' . "\n";
print "\n";


# ASSUMES the file directory-dir-nocode.pl exists in $ENV{PATH}
# In Beginning Perl, the file is directory-dir.pl
# directory-dir-nocode.pl is the same without the explanatory prints

my @result = `perl directory-dir-nocode.pl`;

my $size = 0;  my $i = 0;

foreach (@result) {
  if (/^.{30}[drwox]*\t(\d+)$/) {
    $size += $1;
    $i++;
  }
}

print "Total size of $i files: $size\n";

print "\n";
