#!/bin/perl -w

use strict;

##my $var = 11;

{
  my $var = 7;
}

if (defined $var) {
  print $var . "\n";
} else {
  print "\$var not defined\n";
}
