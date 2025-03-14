#!/bin/perl -w

# bp 165

use strict;

print "\n";
print '$_ = \'1: A silly sentence (495,a) *BUT* one which will be useful. (3)\';' . "\n";
print '  print "\$1 is \'$1\'\n" if defined $1;' . "\n";
print '  print "\$2 is \'$2\'\n" if defined $2;' . "\n";
print '  print "\$3 is \'$3\'\n" if defined $3;' . "\n";
print '  print "\$4 is \'$4\'\n" if defined $4;' . "\n";
print '  print "\$5 is \'$5\'\n" if defined $5;' . "\n";
print "\n";


print "Enter the string: ";
$_ = <STDIN>;

print "Enter a regular expression: ";
my $pattern = <STDIN>;
chomp($pattern);

if (/$pattern/) {
  print "The text matches the pattern '$pattern'\n";
  print "\$1 is '$1'\n" if defined $1;
  print "\$2 is '$2'\n" if defined $2;
  print "\$3 is '$3'\n" if defined $3;
  print "\$4 is '$4'\n" if defined $4;
  print "\$5 is '$5'\n" if defined $5;
} else {
  print "'$pattern' was not found\n";
}

print "\n";
