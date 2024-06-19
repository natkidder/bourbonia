#!/bin/perl -w
# bp 221

use strict;

print "\n";
print 'symlink($filetolink, $linkname) or die "link creation failed: $!";' . "\n";
print 'my $readlinkresult = readlink($linkname);' . "\n";
print "\n";


my $filetolink = 'links.pl';
my $linkname   = 'linktolinks.pl';

symlink($filetolink, $linkname) or die "link creation failed: $!";

print "link created OK!\n";

my $readlinkresult = readlink($linkname);
print "$linkname is a symbolic link to $readlinkresult\n";

print "\n";
