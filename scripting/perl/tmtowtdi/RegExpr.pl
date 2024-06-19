#!/bin/perl -w

# tests regular expressions

use strict;

print "Enter expression to evaluate: ";
my $testExpr = <STDIN>;
chomp $testExpr;

print "Enter regular expression: ";
my $regExpr = <STDIN>;
chomp $regExpr;

if ($testExpr =~ /$regExpr/i) {
  printf "'$testExpr' does hold '$regExpr'\n";
} else {
  printf "'$testExpr' does NOT hold '$regExpr'\n";
}
