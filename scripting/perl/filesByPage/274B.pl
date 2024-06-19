#!/bin/perl -w
# bp 274

use strict;
use Person7;

print "\n";
Person7->CriticalCodeLines();
print "\n";


print "In the beginning: ", Person7->headcount, "\n";
my $object = Person7->new(
  lastname     => "Galilei",
  firstname    => "Galileo",
  address      => "9.81 Pisa Apts.",
  occupation   => "bombardier"
);
print "Population now: ", Person7->headcount, "\n";

my $object2 = Person7->new(
  lastname     => "Einstein",
  firstname    => "Albert",
  address      => "9E16 Relativity Drive",
  occupation   => "plumber"
);
print "Population now: ", Person7->headcount, "\n";
print "\n";
print 'foreach my $person(Person7->everyone()) {' . "\n";
print '  print $person->firstname, " ", $person->lastname(), "\n";' . "\n";
print '}' . "\n";
print "\n";


print "People we know: \n";
foreach my $person (Person7::everyone()) {
  print $person->firstname, " ", $person->lastname, "\n";
}

print "\n";
