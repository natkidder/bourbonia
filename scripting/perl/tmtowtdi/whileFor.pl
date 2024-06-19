#!/bin/perl -w

# bp 96

use strict;

my @names = qw|John Joe Mary Sue|;

print "\n\nprocessing using a while loop: while (\$i <= \$#names) {\n";

my $i = 0;
while ($i <= $#names) {
  print "      Hello $names[$i]!\n";
  $i++;
}

print "\nprocessing using a for loop: for (my \$i = 0; \$i <= \$#names; \$i++) {\n";

for (my $i = 0; $i <= $#names; $i++) {
  print "      Hello $names[$i]!\n";
}
print "\n";
