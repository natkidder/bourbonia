#!/bin/perl
# illustrates perl escape sequences

use strict;

my $input ;

print ("\\t:   \'\t\'","\n");
$input = <STDIN>;
print "\\n:   \'\n\'","\n";
$input = <STDIN>;
print "\\r:   \'\r\'","\n";
$input = <STDIN>;
print "\\b:   \'\b\'","\n";
$input = <STDIN>;
print "\\a:   \'\a\'","\n";
$input = <STDIN>;
print "\\x{3F}:    \'\x{3F}\'","\n";
print "\n";

