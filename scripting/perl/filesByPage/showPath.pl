#!/bin/perl -w

use strict;

for my $path (split ':', $ENV{PATH}) {
  print "$path\n";
}
