#!/bin/perl -w
# bp 274

use strict;
use Person5;

print "\n";
Person5->CriticalCodeLines;
print "\n";
print 'my $object = Person5->new(' . "\n";
print '  lastname     => "Galilei",' . "\n";
print '  firstname    => "Galileo",' . "\n";
print '  address      => "9.81 Pisa Apts.",' . "\n";
print '  occupation   => "bombardier"' . "\n";
print ');' . "\n";
print 'print "Population now: ", Person5->headcount(), "\n";' . "\n";
print "\n";


print "In the beginning: ", Person5->headcount(), "\n";
my $object = Person5->new(
  lastname     => "Galilei",
  firstname    => "Galileo",
  address      => "9.81 Pisa Apts.",
  occupation   => "bombardier"
);
print "Population now: ", Person5->headcount(), "\n";

my $object2 = Person5->new(
  lastname     => "Einstein",
  firstname    => "Albert",
  address      => "9E16 Relativity Drive",
  occupation   => "plumber"
);
print "Population now: ", Person5->headcount(), "\n";

print "\n";
