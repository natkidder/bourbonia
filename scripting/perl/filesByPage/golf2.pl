#!/bin/perl -w

$cats::x = 10;
package cats;
print "undeclared \$x = $x\n";
