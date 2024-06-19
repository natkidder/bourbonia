#!/bin/perl -w

# bp 71

use strict;

print "enter 'done' to break out of the loop\n\n";
print "because of the below condition, there's no chomp here: while (<STDIN>) {\n\n";
print "  last if $_ eq \"done\\n\" \n\n";

while (<STDIN>) {
  last if $_ eq "done\n" ;
  print "You entered: $_";
}

print "All done!\n\n";
