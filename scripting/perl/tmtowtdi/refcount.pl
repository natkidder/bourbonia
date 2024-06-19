#!/bin/perl -w
# bp 241

use strict;

print "\n";
print "this program prints nothing; it just illustrates reference counts.\n\n";
print 'my $ref;' . "\n";
print '{' . "\n";
print '  my @array = (1, 2, 3);' . "\n";
print '  $ref = \@array;' . "\n";
print '  my $ref2 = \@array;' . "\n";
print '  $ref2 = "Hello!";' . "\n";
print '}' . "\n";
print 'undef $ref;' . "\n";
print "\n";


my $ref;
{
  my @array = (1, 2, 3);
  $ref = \@array;
  my $ref2 = \@array;
  $ref2 = "Hello!";
}
undef $ref;
