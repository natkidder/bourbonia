#!/bin/perl -w

# bp 269

use strict;

print 'use Person3; ' . "\n";
print 'my $object = Person3.new( ' . "\n";
print '  lastname	=> "Galilei",' . "\n";
print '  firstname	=> "Galileo",' . "\n";
print '  address	=> "9.81 Pisa Apts.",' . "\n";
print '  occupation	=> "bombardier"' . "\n";
print '); ' . "\n";


use Person3;
showNew();

my $object = Person3->new(
  lastname	=> "Galilei",
  firstname	=> "Galileo",
  address	=> "9.81 Pisa Apts.",
  occupation	=> "bombardier"
);
