#!/bin/perl -w

#my @jobs = qx/jobs/;
my $job = "";
my $line;
open P1, 'jobs' or die "could not run jobs $!"
while ($line = <P1>) {
  print "$line\n";
}
#print @jobs[0];
