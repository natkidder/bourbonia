#!/bin/perl -w

# bp 113

use strict;

my $who = "Ian";

print "\n\n";
print '  my %where = (' . "\n";
print '       Gary     => "Dallas",' . "\n";
print "\n";

my %where = (
     Gary     => "Dallas",
     Lucy     => "Exeter",
     Ian      => "Reading",
     Samantha => "Oregon"
);

print '   print "Gary lives in ", $where{Gary}, "\n";' . "\n";
print "Gary lives in ", $where{Gary}, "\n";
print "$who lives in $where{$who}\n";
print "\n";
