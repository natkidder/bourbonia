#!/bin/perl -w
# bp 195

use strict;

print "\n";
print 'open(FH, \'perl sortFile2.pl gettysburg.txt |\');' . "\n";
print 'while (<FH>) { print if ($i % 3 == 0);  $i++; }' . "\n";
print "\n";


open(FH, 'perl sortFile2.pl gettysburg.txt |');

my $i = 1;

while (<FH>) {
  if ($i % 3 == 0) {
    print;
  }
  $i++;
}

close FH;

print "\n";
