#!/bin/perl -w
# bp 207

use strict;

print "\n";
print 'my $result = index($string, $substring);' . "\n";
print "\n";


print "Enter a string:    ";
chomp(my $string = <STDIN>);

print "Enter a substring: ";
chomp(my $substring = <STDIN>);

my $result = index($string, $substring);

if ($result != -1) {
  print "the substring '$substring' was found at index: $result of '$string'\n";
} else {
  print "the substring was not found\n";
}

print "\n";
