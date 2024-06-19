#!/bin/perl -w

# bp 99

use strict;

my $element;

print "\n\n";
print "foreach \$element ('zero', 'one', 'two') {\n\n";

foreach $element ('zero', 'one', 'two') {
  print "the element is: $element\n";
}
print "\n";
