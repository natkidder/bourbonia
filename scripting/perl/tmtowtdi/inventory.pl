#!/bin/perl -w
# bp 196

use strict;

print "\n";
print 'while (<STDIN>) {' . "\n";
print '  chomp;' . "\n";
print '  last if $_ eq "";' . "\n";
print '  $inventory{lc $_}++;' . "\n";
print '}' . "\n";
print 'open(SORT, "| perl sortFile2.pl");' . "\n";
print "\n";
print 'while (my ($item, $quantity) = each %inventory) {' . "\n";
print '  if ($quantity > 1) {' . "\n";
print '    $item =~ s/^(\w+)\b/$1s/   unless $item =~ /^\w+s\b/;' . "\n";
print '  }' . "\n";
print '  print SORT "$item: $quantity\n"' . "\n";
print '}' . "\n";
print "\n";



my %inventory;
print "Enter individual items, followed by a new line.\n";
print "Enter a blank line to finish.\n";

while (<STDIN>) {
  chomp;
  last if $_ eq "";
  $inventory{lc $_}++;
}

open(SORT, "| perl sortFile2.pl");

while (my ($item, $quantity) = each %inventory) {
  if ($quantity > 1) {
    $item =~ s/^(\w+)\b/$1s/   unless $item =~ /^\w+s\b/;
  }
  print SORT "$item: $quantity\n"
}

close SORT;

print "\n";
