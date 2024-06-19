#!/bin/perl -w

# bp 67

use strict;

my $countdown = 5;

until ($countdown <= 0) {
  print "Counting down: $countdown\n";
  --$countdown;
}
