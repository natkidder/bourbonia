#!/bin/perl -w

# bp 48

use strict;

print "\n";
print "after running this, type: \$ echo \$? to get the number in clock 256\n\n";

print 'chomp(my $value = <STDIN>)' . "\n";
print "\n";


print "enter value to return to the calling program: ";
chomp(my $value = <STDIN>);


print "\n";

exit($value);

