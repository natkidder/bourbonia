#!/bin/perl -w

# bp 141

$x = 10;

print "\n";
print "before: \$x = $x\n";
print "\n";
change_global_not();
print "\n";
print "after: \$x = $x\n";
print "\n";

sub change_global_not {
  my $x = 20;
  print "In change_global_not(): my \$x = $x\n";
}
