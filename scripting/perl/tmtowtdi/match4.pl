#!/bin/perl -w

# bp 152

use strict;

print "\n";
print 'my $test1 = "The dog is in the kennel";' . "\n";
print 'my $test2 = "The sheepdog is in the field";' . "\n";
print 'if ($test1 =~ / dog/) {' . "\n";
print 'if ($test2 =~ / dog/) {' . "\n";
print "\n";


my $test1 = "The dog is in the kennel";
my $test2 = "The sheepdog is in the field";

if ($test1 =~ / dog/) {
  print "This dog's at home\n";
}

if ($test2 =~ / dog/) {
  print "This dog's at work\n";
}

print "\n";
