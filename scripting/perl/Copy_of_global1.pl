#!/bin/perl -w

# bp 137

print "\n\n";
print '   $x = 10;' . "\n";
print '   access_global();' . "\n";
print '   sub access_global {' . "\n";
print '     print "value of global \$x: $x\n";' . "\n";
print '   }' . "\n";
print "\n";


$x = 10;

access_global();

sub access_global {
  print "value of global \$x: $x\n";
}

print "\n";
