#!/bin/perl -w

# bp 157

use strict;

print "\n";
print 'my $syllable = "ink";' . "\n";
print 'while (<>) { ' . "\n";
print '  print if /$syllable$/; ' . "\n";
print '  print "  " . $_ if /ink/;' . "\n";
print '  print "    ". $_ if $_ =~ /ink/;' . "\n";
print '  } ' . "\n";
print "\n";


my $syllable = "ink";

while (<>) {
  print if /$syllable$/;
  print "  " . $_ if /ink/;
  print "    ". $_ if $_ =~ /ink/;
}

print "\n";
