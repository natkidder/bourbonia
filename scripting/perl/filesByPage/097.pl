#!/bin/perl -w

# bp 97

use strict;

my @sales = (69, 118, 97, 110, 103, 101, 108, 105, 76, 111, 118, 101);
my @months = qw(Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec);

print "\@sales = @sales\n\@months = @months";

print "\n\n";
print "Second quarter sales:\n";
print "@months[3..5]\n@sales[3..5]\n";
my @q2 = @sales[3..5];
print "\n";

#Incorrect results in May, Aug, Oct, Nov and Dec!

print 'revise array values: @sales[4, 7, 9..11] = (68, 101, 114, 111, 117);' . "\n";
@sales[4, 7, 9..11] = (68, 101, 114, 111, 117);
print "\@sales = @sales\n";
print "\n";

#Swap Apr and May

print 'swap array values: @sales[3, 4] = @sales[4, 3];' . "\n";
@sales[3, 4] = @sales[4, 3];
print "\@sales = @sales\n";
print "\n";
