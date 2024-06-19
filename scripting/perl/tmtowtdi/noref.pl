#!/bin/perl -w
# bp 235

use strict;

print "\n";
print 'my $ref = [1, 2, 3];' . "\n";
print 'print "Before: $ref\n";' . "\n";
print 'print "Deref: @{$ref}\n";' . "\n";
print '$ref++;' . "\n";
print 'print "After:  $ref\n";' . "\n";
print 'print "Deref: @{$ref}\n";' . "\n";
print "\n";

my $ref = [1, 2, 3];
print "Before: $ref\n";
print "Deref: @{$ref}\n";
$ref++;
print "After:  $ref\n";
print "Deref: @{$ref}\n";
