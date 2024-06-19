#!/bin/perl -w

# bp 129

use strict;

sub version {
  print "Beginning Perl's \"Hello, world.\" version 2.0\n";
}

my $option = shift;   # defaults to shifting @ARGV

print "\n\n";
print 'version() if $option eq "-v" or $option eq "--version";' . "\n";
print "\n";

version() if $option eq "-v" or $option eq "--version";

print "Hello, world.\n";

print "\n";
