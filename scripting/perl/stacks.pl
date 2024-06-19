#!/bin/perl -w

# bp 106

use strict;

my $hand;
my @pileofpaper = ("letter", "newspaper", "gas bill", "notepad");

print "\n\n";
print "Here's what's on the desk: @pileofpaper\n";

print "You pick something off the top of the pile.\n";
print '  $hand = pop @pileofpaper;' . "\n";
$hand = pop @pileofpaper;
print "You now have a $hand in your hand\n";
print "\n";

print "You put the $hand away, and pick up something else.\n";
print '  $hand = pop @pileofpaper;' . "\n";
$hand = pop @pileofpaper;
print "You picked up a $hand\n";
print "\n";

print "Left on the desk is: @pileofpaper\n";
print "\n";

print "You pick up the next thing, and throw it away.\n";
print '  pop @pileofpaper;' . "\n";
pop @pileofpaper;
print "\n";

print "You put the $hand back onto the pile\n";
print '  push @pileofpaper, $hand;' . "\n";
push @pileofpaper, $hand;
print "\n";

print "You also put a leaflet and a bank statement on the pile.\n";
print '  push @pileofpaper, "leaflet", "bank statement";' . "\n";
push @pileofpaper, "leaflet", "bank statement";
print "\n";

print "left on the desk is: @pileofpaper\n";
print "\n";
