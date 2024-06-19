#!/bin/perl -w

# bp 41

print "\n";
print "Note in perl, you can set up any generic code block {}, without any prepositions\n\n";
print "\n";
print "'use strict' with \$record global var declaration\n\n";

use strict;

my $record;

$record = 4;
print "Before the block, we're at \$record ", $record, "\n";
{
  my $record;
  $record = 7;
  print "Inside the block, we're at \$record ", $record, "\n";
}

print "After the block, we're still at \$record ", $record, "\n";
print "\n";
