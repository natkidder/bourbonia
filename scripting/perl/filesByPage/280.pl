#!/bin/perl -w
# bp 280

use strict;
use Person8;

my @objects;

print "\n";
Person8::CriticalCodeLines();
print "Press <Ent> to Cont: "; my $cont = <STDIN>;

print "\n";
print '  $objects[0] = Person8->new (' . "\n";
print '     lastname    => "Galilei",' . "\n";
print '     firstname   => "Galileo",' . "\n";
print '     address     => "9.81 Pisa Apts.",' . "\n";
print '     occupation  => "bombardier"' . "\n";
print '  );' . "\n";
print '  $objects[0]->printletter("You owe me money.  Please pay it.");' . "\n";
print "\n";


$objects[0] = Person8->new (
   lastname    => "Galilei",
   firstname   => "Galileo",
   address     => "9.81 Pisa Apts.",
   occupation  => "bombardier"
);
$objects[0]->printletter("You owe me money.  Please pay it.");

print "\n";
