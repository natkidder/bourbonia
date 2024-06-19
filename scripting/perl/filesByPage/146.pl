#!/bin/perl -w

# bp 146

print "\n";
print 'my $name = "NKIDDER"; my $pass = "doggie"; my $hostname = "Homer";' . "\n";
my $name = "NKIDDER"; my $pass = "doggie"; my $hostname = "Homer";

print 'logon( username => $name, password => $pass, host => $hostname);' . "\n";
logon( username => $name, password => $pass, host => $hostname);
print "\n";

sub logon {
  die "Parameters to logon should be even " if @_ % 2;
  my %args = @_;
  print 'print "Logging on to host $args{host}\n";' . "\n";
  print "Logging on to host $args{host}\n";
  print " using login $args{username}\n";
  print " with password $args{password}\n";
}
