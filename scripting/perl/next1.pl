#!/bin/perl -w

# bp 72

use strict;

print "\n'next' exits the body of the loop without exiting the loop itself--press <Ent> at the prompt\n";
print "^z to exit the program\n\n";

print 'if ($_ eq "\n") {' . "\n";
print '  next;' . "\n\n";

print "Please enter some text:\n";
while (<STDIN>) {
  if ($_ eq "\n") {
    next;
  }
  chomp;
  print "You entered: [$_]\n";
}
print "\ninaccessible string\n";
