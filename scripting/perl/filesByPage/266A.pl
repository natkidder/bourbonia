#!/bin/perl -w
# bp 266

use strict;

print "\n";

print 'my $a = {};' . "\n";

my $a = {};

print '$a is a, ref($a), ', ref($a), " reference\n";

print 'bless($a, "Person1");' . "\n";

bless($a, "Person1");
print '$a is a, ref($a), ', ref($a), " reference\n";

print "\n";
print "There is no Animal::Vertebrate::Mammal package, but we're not calling methods\n";
print 'bless($a, "Animal::Vertebrate::Mammal");' . "\n";

bless($a, "Animal::Vertebrate::Mammal");
print '$a is a, ref($a), ', ref($a), " reference\n";

print "\n";
