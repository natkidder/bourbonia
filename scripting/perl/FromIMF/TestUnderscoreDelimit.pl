#!/bin/perl -w

use strict;

my @ary = qw_a b c d e_;
for (@ary) { print $_ . "\n"; }
