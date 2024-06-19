#!/bin/perl -w
# bp 272

use strict;
use Person4;

print "\n";
Person4::showClassCode;

print "\n";
print 'my $object = Person4->new(' . "\n";
print '  lastname     => "Galilei",' . "\n";
print '  firstname    => "Galileo",' . "\n";
print '  address      => "9.81 Pisa Apts.",' . "\n";
print '  occupation   => "bombardier"' . "\n";
print ');' . "\n";
print 'print "This person\'s last name: ", $object->lastname(), "\n";' . "\n";
print "\n";


my $object = Person4->new(
  lastname     => "Galilei",
  firstname    => "Galileo",
  address      => "9.81 Pisa Apts.",
  occupation   => "bombardier"
);

print "This person's last name: ", $object->lastname(), "\n";

print "\n";
