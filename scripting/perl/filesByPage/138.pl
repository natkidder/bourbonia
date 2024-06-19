#!/bin/perl -w

# bp 138

print "\n\n";
print '   $x = 10;' . "\n";
print '   print "Before: $x";' . "\n";
print '   change_global();' . "\n";
print '   print "After:  $x";' . "\n";
print '   ' . "\n";
print '   sub change_global {' . "\n";
print '     $x = 20;' . "\n";
print '     print "change_global(): $x"' . "\n";
print "\n";


$x = 10;

print "Before: \$x = $x\n";
change_global();
print "After:  \$x = $x\n";
print "\n";

sub change_global {
  $x = 20;
  print "in change_global(): \$x = $x\n"
}
