#!/bin/perl -w

# bp 47

use strict;

print "\n";
print "note use of <STDIN>\n";
print "\n";

print 'my $yen = <STDIN>' . "\n";
print 'chop($yen) would knock off the last character' . "\n";
print 'chomp($yen) knocks off only the last char if a newline' . "\n";
print "\n";

print "Currency converter\n\nPlease enter the exchange rate: ";
my $yen = <STDIN>;
chomp($yen);
print "\n";

print '"49,518 yen is ", (49_518/$yen), " dollars' . "\n";
print "\n";
print "49,518 yen is ", (49_518/$yen), " dollars\n";
print "   360 yen is ", (360/$yen), " dollars\n";
print "30,510 yen is ", (30_150/$yen), " dollars\n";
print "\n";
