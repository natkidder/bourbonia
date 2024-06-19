#!/bin/perl -w

# bp 80

use strict;

my @seasons = qw/winter spring summer fall/;
my $i;

for ($i = 0; $i < 4; $i++) {
  print $seasons[$i] . "\n";
}

my @coins = qw#penny nickel dime quarter#;

while (my $coin = shift(@coins)) {
  print $coin . "   ";
}

