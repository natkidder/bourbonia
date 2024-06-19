#!/bin/perl -w

print $ARGV[0] . "\n";
if ($ARGV[0]) {
  print "\$ARGV[0] exists\n";
  while (<>) {
    print $_;
  }
} else {
  die "ShowFile arg1: file to display\n";
}
