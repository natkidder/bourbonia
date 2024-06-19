#!/bin/perl -w
# bp 210

use strict;

print "Enter a string:                ";
chomp (my $string = <STDIN>);

print "Enter 1st transliteration arg: ";
chomp (my $old = <STDIN>);

print "Enter 2nd transliteration arg: ";
chomp (my $new = <STDIN>);

print "\n";
print "\n";

$string =~ tr/$old/new/ ;

print "result: $string\n";

