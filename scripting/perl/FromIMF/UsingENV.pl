#!/bin/perl -w

print $_ . ": " . $ENV{$_} . "\n\n" foreach (keys %ENV);
print "PWD: " . $ENV{PWD} . "\n";
