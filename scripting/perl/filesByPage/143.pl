#!/bin/perl -w

# bp 143

use strict;

my (@nums1, @nums2);

print "\n";
print '@nums1 = (2, 4, 6);' . "\n";
print '@nums2 = (8, 10, 12);' . "\n";

@nums1 = (2, 4, 6);
@nums2 = (8, 10, 12);

print 'process_arrays(@nums1, @nums2);' . "\n";
print "\n";
process_arrays(@nums1, @nums2);

sub process_arrays {
  print 'my(@a, @b) = @_;' . "\n";
  my(@a, @b) = @_;

  print "contents of \@a:\n";
  print "[$_] " foreach @a;
  print "\n\n";

  print "contents of \@b:\n";
  print "[$_] " foreach @b;
  print "\n";
}
