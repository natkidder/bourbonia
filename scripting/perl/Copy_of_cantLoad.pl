#!/bin/perl -w
# bp 262

use strict;

print "\n";
print 'require "not_there.pl";' . "\n";
print "\n";


# Programmer: do NOT create a 'not_there.pl' file except for testing

require "not_there.pl";
