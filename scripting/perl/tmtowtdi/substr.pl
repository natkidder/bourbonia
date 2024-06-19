#!/bin/perl -w
# bp 209

use strict;

print "Enter a string:         ";
chomp (my $string = <STDIN>);

print "Enter starting index:   ";
chomp (my $index = <STDIN>);

print "Enter length:           ";
chomp (my $length = <STDIN>);

print "\n";
print 'my $s = substr($string, $index, $length);' . "\n";
print "\n";

my $s = substr($string, $index, $length);

print "result: $s\n";

# now, overwrite string
print "\n";
print 'substr($string, 0, 5) = \'hello, world!\';' . "\n";
print "\n";

substr($string, 0, 5) = 'hello, world!';

print "string is now: $string\n";

print "\n";
