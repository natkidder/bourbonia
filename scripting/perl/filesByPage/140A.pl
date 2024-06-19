#!/bin/perl -w

# bp 140

use strict;

print "\n\n";
print '   use strict;' . "\n";
print '   $main::x = 10;  ## legal with explicit package modifier' . "\n";
print "\n";

$main::x = 10;
print $main::x . "\n";
print "\n";
