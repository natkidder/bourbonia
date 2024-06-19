#!/bin/perl -w
use File::Path;  

print "Where to? ";
chomp($newdir = <STDIN>);
chdir($newdir) or die "Cannot chdir to $newdir: $!";
foreach (<*>) {
    print "$_\n";
}
