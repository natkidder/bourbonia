#!/bin/perl -w

# bp 181

use strict;

print "NOTE: run this file with gettysburg[2].txt as arguments\n";
print "\n";
print 'my $lineno;' . "\n";
print 'print "\$lineno undefined\n" unless defined ($lineno);' . "\n";
print 'my $lineno = 1;' . "\n";
print 'print "\$lineno defined\n" if defined ($lineno);' . "\n";
print 'while (<>) {' . "\n";
print '  print $lineno++;' . "\n";
print '  print ": $_";' . "\n";
print '}' . "\n";
print "\n";

my $lineno;
print "\$lineno undefined\n" unless defined ($lineno);
my $lineno = 1;
print "\$lineno defined\n" if defined ($lineno);

while (<>) {
  print $lineno++;
  print ": $_";
}

