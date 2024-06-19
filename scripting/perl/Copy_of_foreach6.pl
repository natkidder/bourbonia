#!/bin/perl -w

# bp 104

use strict;

print "\n\n";
print "qw;; does work\n";

print "\n";
print 'my @a = qw;hello world good bye;;' . "\n";
print 'print "[$_]\n" foreach (@a);' . "\n";
print "\n";

my @a = qw;hello world good bye;;

print "[$_]\n" foreach (@a);

print "\n";
