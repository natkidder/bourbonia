#!/bin/perl -w

# bp 121

use strict;

print "\n\n";
print 'my %colors = (' . "\n";
print '	red    => \'#FF0000\',' . "\n";
print 'print "Red is    $colors{red}";' . "\n";
print "\n";

my %colors = (
	red    => '#FF0000',
	green  => '#00FF00',
	blue   => '#0000FF',
	white  => '#FFFFFF',
	black  => '#000000',
	purple => '#520063'
);

print "Red is    $colors{red}\n";
print "Blue is   $colors{blue}\n";
print "Purple is $colors{purple}\n";

print "\n";
