#!/bin/perl -w
# bp 248

print "\nType this up: it's good reference practice\n\n";
use strict;
my (%addressbook, $name, $who);

sub EnterAddr {
  my ($address, $phone);
  print "Give me a name:"; chomp($name    = <>);
  print "Address:";        chomp($address = <>);
  print "Phone Number:";   chomp($phone   = <>);
  $addressbook{$name} = {
    address => $address,
    phone   => $phone
  };
}

sub PrintOneAddr {
  if (exists $addressbook{$who}) {
    print "$who\n";
    print "Address  : ", $addressbook{$who}{address}, "\n";
    print "Phone nbr: ", $addressbook{$who}{phone}, "\n";
  }
}

sub PrintAllAddr {
  foreach $who (keys %addressbook) {
    print "$who\n";
    print "Address  : ", $addressbook{$who}{address} . "\n";
    print "Phone nbr: ", $addressbook{$who}{phone} . "\n";
  }
}

sub PrintAllFriends {
  foreach $who (keys %addressbook) {
    print "$who\n";
    print "Address  :", $addressbook{$who}{address} . "\n";
    print "Phone nbr:", $addressbook{$who}{phone} . "\n";
    my @friends = @{$addressbook{$who}{friends}};
    print "Friends:\n";
    foreach (@friends) {
      print "\t$_\n";
    }
  }
}

sub PrintAllFriends2 {
  $, = "\t";      # Set output field separator for tabulated display
  my @todo = @_;  # Start point
  my %seen;
  while (@todo) {
    my $who = shift @todo;  # Get person from the end
    $seen{$who}++;         # Mark them as seen
    my @friends = @{$addressbook{$who}{friends}};
    print "$who has friends: ", @friends, "\n";
    foreach (@friends) {
      # Visit unless they're already visited
      push @todo, $_ unless exists $seen{$_};
    }
  }
}
