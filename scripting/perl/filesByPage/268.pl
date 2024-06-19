#!/bin/perl -w
# bp 268

use strict;
use Person2;

print "\n";
print 'use Person2;' . "\n";
Person2->showNew();
print "\n";
print 'my $person = Person2->new();' . "\n";
print 'my $person2 = Person2::new();' . "\n";
print "\n";


my $person = Person2->new();
my $person2 = Person2::new();
