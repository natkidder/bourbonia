#!/bin/perl -w
# bp 222

use strict;

# first prompt the user for a directory name and attempt
# to create the directory in the current directory

print "Please enter a directory name: ";
chomp(my $dir = <STDIN>);

mkdir $dir, 0777 or die "Failed to make directory $dir: $!\n";
print "Made the directory $dir OK\n";

# so far so good - now, change directory into the directory you just made

chdir $dir or die "Failed to change into $dir: $!\n";
print "Changed into $dir OK\n";

# OK, now move the file ../a.dat into this new directory
# giving it a new name

print "Enter a new file name: ";
chomp(my $newName = <STDIN>);
rename "../a.dat", $newName or die "rename from ../a.dat failed: $!\n";
print "File moved successfully!\n";

# list the contents of the directory, using a directory handle

print "Contents of the new directory:\n";
opendir DH, '.' or die "opendir failed: $!";
my $filename;
while ($filename = readdir(DH)) {
  print "     $filename\n";
}
close DH;

# that's it, say goodbye

print "We are all done... goodbye!\n";
