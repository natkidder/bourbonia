#!/bin/perl -w

# bp 141

use strict;

my $var = 10;
print "\n";
print "before: \$var = $var\n";
print "\n";
change_var($var);
print "\n";
print "after: \$var = $var\n";
print "\n";

sub change_var {
  print "In change_var(\$var) before: $_[0]\n";
  print "\n";
  ++$_[0];
  print "In change_var(\$var) after: $_[0]\n";
}
