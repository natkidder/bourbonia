#!/bin/perl -w
# bp 261

use strict;

print "\n";
print 'my $a = "Been there, done that, got the T-shirt";' . "\n";
print "\n\@INC = @INC\n\n";
print 'do "printIt.pl"' . "\n";
print "\n";

my $a = "Been there, done that, got the T-shirt";
do "printIt.pl";

print "\n";
