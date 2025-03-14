#!/bin/perl -w

# bp 165

use strict;

print "Enter test string: ";
chomp($_ = <STDIN>);

print "Enter a regular expression: ";
my $pattern = <STDIN>;
chomp($pattern);

if (/$pattern/) {
  print "The text matches the pattern '$pattern'\n";
  print "\$1 is '$1'\n" if defined $1;
  print "\$2 is '$2'\n" if defined $2;
  print "\$3 is '$3'\n" if defined $3;
  print "\$4 is '$4'\n" if defined $4;
  print "\$5 is '$5'\n" if defined $5;
} else {
  print "'$pattern' was not found\n";
}

print "\n";
