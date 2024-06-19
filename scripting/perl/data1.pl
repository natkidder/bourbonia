#!/bin/perl -w
# bp 295

use strict;

system("tput clear");
print "\n";
print 'use Data::Dumper qw(Dumper);  # import the dumper function' . "\n";
print 'my @a = (' . "\n";
print '  \'hello, world\',' . "\n";
print '  1234.56,' . "\n";
print '  [ 2, 4, 6 ],' . "\n";
print '  { one => \'first\', two => \'second\' }' . "\n";
print ');' . "\n";
print 'my $r = \@a;' . "\n";
print 'print Dumper($r);  ' . "\n";
print "\n";


use Data::Dumper qw(Dumper);  # import the dumper function

# create a complex data type

my @a = (
  'hello, world',
  1234.56,
  [ 2, 4, 6 ],
  { one => 'first', two => 'second' }
);

# create a reference to it

my $r = \@a;

# dump it out

print Dumper($r);  

print "\n";
