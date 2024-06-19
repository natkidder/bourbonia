#!/bin/perl -w

# bp 169

use strict;

print "\n";
print 's/$regex/--$1--/;' . "\n";
print "\n";

print "Enter string to switch words on: ";
my $string = <STDIN>; chomp $string;

print "Enter regular expression: ";
my $regex = <STDIN>; chomp $regex;

print "2nd arg to subst: --\$1-- \n";

$string =~ s/$regex/--$1--/;
print $string, "\n";

print "\n";
