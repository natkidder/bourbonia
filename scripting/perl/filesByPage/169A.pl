#!/bin/perl -w

# bp 169

use strict;

print "\n";
print '$_ = "there are two major products that come out of Berkeley: LSD and UNIX";' . "\n";
print 's/(\w+)\s+(\w+)/$2 $1/;' . "\n";
print "\n";


$_ = "there are two major products that come out of Berkeley: LSD and UNIX";
# Jeremy Anderson

s/(\w+)\s+(\w+)/$2 $1/;
print $_, "?\n";

print "\n";
