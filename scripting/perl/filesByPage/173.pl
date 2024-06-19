#!/bin/perl -w

# bp 173

use strict;

print "\n";
print 'my $passwd = "kake:x:10018:10020:/home/kake:/bin/bash";' . "\n";
print 'my @fields = split /:/, $passwd;' . "\n";
print "\n";


my $passwd = "kake:x:10018:10020:/home/kake:/bin/bash";
my @fields = split /:/, $passwd;
print "Login Name \$fields[0]: $fields[0]\n";
print "User ID \$fields[2]: $fields[2]\n";
print "Home Directory \$fields[5]: $fields[5]\n";
print "\n";
