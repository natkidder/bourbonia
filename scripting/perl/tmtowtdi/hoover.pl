#!/bin/perl -w
# bp 298

use strict;
use File::Find;

print "This is a dangerous file to run!!\n";
print "Do you wish to run it? (n): ";
my $affirm = "y";
my $runFile = <STDIN>;
chomp($runFile);
$runFile = lc($runFile);
if ($runFile ne $affirm) {
  exit;
}

find(\&cleanup, "/");

sub cleanup {
  # Not been accessed in six months?
  if (-A 180) {
    print "Deleting old file $_ \n";
###    unlink $_ or print "oops, couldn't delete $_\n";
    return;
  }

  open (FH, $_) or die "Couldn't open $_: $!\n";
  foreach (1..5) {  ### Line must be of top five
    my $line = <FH>;
    if ($line =~ /Perl|Camel|important/i) {
      ### spare it
      return;
    }
  }
  print "Deleting unimportant file $_ \n";
###  unlink $_ or print "oops, couldn't delete $_: $! \n";
}

