#!/bin/perl -w

# bp 93

use strict;

my @questions = qw<Java Python Perl C>;
my @punchlines = (
  "None. Change it once, and it's the same everywhere.",
  "One.  He just stands below the socket and the world revolves around him.",
  "A million.  One to change it, the rest to try to do it in fewer lines.",
  '"CHANGE?!"'
);

print "\n\n";
print 'foreach (0..$#questions) {' . "\n";
print '  print "How many $questions[$_] ";' . "\n";
print '  print "programmers does it take to change a light bulb?\n";' . "\n";
print '  sleep 2;' . "\n";
print '  print $punchlines[$_], "\n\n";' . "\n";
print '  sleep 1;' . "\n";
print '}' . "\n";
print "\n";

foreach (0..$#questions) {
  print "How many $questions[$_] ";
  print "programmers does it take to change a light bulb?\n";
  sleep 2;
  print $punchlines[$_], "\n\n";
  sleep 1;
}
print "\n";
