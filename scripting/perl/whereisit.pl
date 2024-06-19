#!/bin/perl -w
# bp 301

use strict;

print "\n";
print "THIS NEEDS WORK\n";
print 'use File::Spec::Functions;' . "\n";
print 'foreach my $path (path()) {' . "\n";
print '  my $test = catfile($path, "sort");' . "\n";
print '  if (-e $test) {' . "\n";
print '    print "Yes, sort is in the $_ directory.\n";' . "\n";
print '    exit;' . "\n";
print '  }' . "\n";
print '}' . "\n";
print "\n";


use File::Spec::Functions;

foreach my $path (path()) {
  my $test = catfile($path, "sort");
  if (-e $test) {
    print "Yes, sort is in the $_ directory.\n";
    exit;
  }
}
print "sort was not found here.\n";

print "\n";
