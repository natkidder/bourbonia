#!/bin/perl -w

# bp 169

use strict;

print "\n";
print '$_ = "Awake! Awake! Fear, Fire, Foes! Awake! Fire, Foes! Awake!";' . "\n";
print 's/Foes/Flee/g;' . "\n";
print "\n";

$_ = "Awake! Awake! Fear, Fire, Foes! Awake! Fire, Foes! Awake!";
# Tolkien, Lord of the Rings

s/Foes/Flee/g;
print $_, "\n";

print "\n";
