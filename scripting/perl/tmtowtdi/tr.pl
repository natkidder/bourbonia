#!/bin/perl -w
# bp 211

print "\n";
print 'while (<>) { tr/a-z/A-Z/; print; }' . "\n";
print "\n";

while (<>) {
  tr/a-z/A-Z/;
  print;
  last if $_ eq "";
}
