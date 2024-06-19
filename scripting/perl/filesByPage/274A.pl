#!/bin/perl -w
# bp 274

use strict;
use Person6;

print "\n";
Person6->CriticalCodeLines;
print "\n";


print "In the beginning: ", Person6->headcount, "\n";
my $object = Person6->new(
  lastname     => "Galilei",
  firstname    => "Galileo",
  address      => "9.81 Pisa Apts.",
  occupation   => "bombardier"
);
print "Population now: ", Person6->headcount, "\n";

my $object2 = Person6->new(
  lastname     => "Einstein",
  firstname    => "Albert",
  address      => "9E16 Relativity Drive",
  occupation   => "plumber"
);
print "Population now: ", Person6->headcount, "\n";
print "\n";
print 'foreach my $person(Person6->everyone()) {' . "\n";
print '  print $person->firstname(), " ", $person->lastname(), "\n";' . "\n";
print '}' . "\n";
print "\n";

print "People we know: \n";
foreach my $person(Person6->everyone()) {
  print $person->firstname(), " ", $person->lastname(), "\n";
}

print "\n";
