#!/bin/perl

# bp 56

use strict;

print "\n" . 'chomp $guess--like all functions, it can take arguments inside parentheses or no' . "\n\n";

print 'my $guess = <STDIN>;' . "\n";
print 'chomp $guess;         ## chomp(<STDIN>) does not work' . "\n";
print 'if ($password eq $guess) {' . "\n";
print 'if ($password ne $guess) {' . "\n\n";

my $password = "foxtrot";
print "Enter the password: ";
my $guess = <STDIN>;
chomp $guess ;
if ($password eq $guess) {
  print "Pass, friend.\n";
}
if ($password ne $guess) {
  die "go away, imposter!\n"
}
print "\n";
