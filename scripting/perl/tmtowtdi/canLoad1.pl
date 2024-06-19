#!/bin/perl -w
# bp 262

use strict;

print "\n";
print 'sub BEGIN {' . "\n";
print '  unshift @INC, "/cygdrive/c/mydocs/career/training"' . "\n";
print '}' . "\n";
print "\n";

sub BEGIN {
  unshift @INC, "/cygdrive/c/mydocs/career/training"
}

require "is_there.pl";
