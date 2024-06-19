#!/bin/perl -w

unless ($ARGV[0]) {
  while (<>) {
    print $_;
  }
} else {
  die "ShowFile arg1: file to display\n";
}
