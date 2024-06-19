#!/bin/perl -w
# bp 238

use strict;

print "\n";
print 'my $href = \%hash;' . "\n";
print 'foreach (keys %{$href}) {' . "\n";
print '  print "Key:   ", $_, "\t";' . "\n";
print '  print "Hash:  ", $hash{$_}, "\t\t";' . "\n";
print '  print "Ref:   ", ${$href}{$_}, "\n";' . "\n";
print '}' . "\n";
print "\n";


my %hash = (
  1 => "January",    2 => "February",   3 => "March",     4 => "April",
  5 => "May",        6 => "June",       7 => "July",      8 => "August",
  9 => "September", 10 => "October",   11 => "November", 12 => "December"
);

my $href = \%hash;
for my $mth (keys %{$href}) {
  print "Key:   ", $mth, "\t";
  print "Hash:  ", $hash{$mth}, "\t\t";
  print "Ref:   ", $$href{$mth}, "\n";
  print "  Ref:   ", $href->{$mth}, "\n";
}

print "\nNote the months are NOT in order\n\n";
