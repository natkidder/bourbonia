#!/bin/perl -w

use strict;

print "\n";
print "illustrates branching using goto\n";
print "\n";

my $i = 1;
my $j = 0;

while ($i < 100) {
  $j += 5;
  if ($j > 101) {
   goto ToHigh;
  }
  $i++;
}

goto TheEnd;
ToHigh:
print "\$j > 100\n";
TheEnd:
print "\nWe have reached the end\n";
