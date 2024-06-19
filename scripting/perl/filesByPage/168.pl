#!/bin/perl -w

# bp 168

use strict;

print "\n";
print '$_ = "Awake! Awake! Fear, Fire, Foes! Awake! Fire, Foes! Awake!";' . "\n";
print 's/Foes/Flee/;' . "\n";
print "\n";

$_ = "Awake! Awake! Fear, Fire, Foes! Awake! Fire, Foes! Awake!";
# Tolkien, Lord of the Rings

s/Foes/Flee/;
print $_, "\n";

print "\n";
