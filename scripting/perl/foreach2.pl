#!/bin/perl -w

# bp 99

@array = qw,America Asia Europe Africa,;
my $element;

print "\n\n";
print 'foreach $element (@array) {', "\n\n";

foreach $element (@array) {
  print $element . "\n";
}
print "\n";
