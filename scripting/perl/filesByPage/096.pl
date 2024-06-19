#!/bin/perl -w

# bp 96

use strict;

my @names = qw|John Joe Mary Sue|;

print "\n\@names: @names \n";

print "\n\nprocessing using a while loop: while (\$i <= \$#names) {\n";

my $i = 0;
while ($i <= $#names) {
  print "      Hello $names[$i]!\n";
  $i++;
}

print "\n\nprocessing using an until loop: until (\$i > \$#names) {\n";

my $i = 0;
until ($i > $#names) {
  print "      Hello $names[$i]!\n";
  $i++;
}

print "\nprocessing using a for loop: for (my \$i = 0; \$i <= \$#names; \$i++) {\n";

for (my $i = 0; $i <= $#names; $i++) {
  print "      Hello $names[$i]!\n";
}
print "\n";
