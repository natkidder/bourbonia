#!/bin/perl -w

# bp 93

use strict;

my @questions = qw%Java Python Perl C%;
my @punchlines = (
  "None. Change it once, and it's the same everywhere.",
  "One.  He just stands below the socket and the world revolves around him.",
  "A million.  One to change it, the rest to try to do it in fewer lines.",
  '"CHANGE?!"'
);

my $questions = @questions;
print "\n\n";
print "Please enter a number between 1 and $questions: ";
my $selection = <STDIN>;
$selection--;
print "\nHow many $questions[$selection] ";
print "developers does it take to change a lightbulb? \n\n";
sleep 2;
print $punchlines[$selection], "\n\n";
