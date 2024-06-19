#!/bin/perl -w

# bp 154

use strict;

$_ = q("I wonder what is the Entish is for 'yes' and 'no'," he thought.);
# Tolkien, Lord of the Rings
print "\n";
print $_ . "\n";
print "\n";

print "Enter some text to find: ";
my $pattern = <STDIN>;
chomp($pattern);

if (/$pattern/) {
  print "The text above matches the pattern '$pattern'.\n";
} else {
  print "'$pattern' was not found.\n";
}

print "\n";
