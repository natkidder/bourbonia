#!/bin/perl -w

# bp 139

print "\n\n";
print '   $main::name   = "Your Name Here";' . "\n";
print '   $Fred::name   = "Fred Flintstone";' . "\n";
print '   print "\$name in package main (the default) is $name";' . "\n";
print '   package Fred;' . "\n";
print '   print "\$name in package Fred               is $name";' . "\n";
print "\n";

$main::name   = "Your Name Here";
$Fred::name   = "Fred Flintstone";
$Barney::name = "Barney Rubble";

print "\$name in package main (the default) is $name\n";
package Fred;
print "\$name in package Fred               is $name\n";
package Barney;
print "\$name is package Barney             is $name\n";
package main;
print "\n";
