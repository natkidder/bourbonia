#!/bin/perl -w

# bp 60

use strict;

print "\n" . '} elsif ($weather eq "raining") {' . "\n";
print "\n" . '} else {' . "\n\n";

print "What's the weather like outside? ";
chomp(my $weather = <STDIN>);
print "How hot is it, in degrees? ";
chomp(my $temperature = <STDIN>);
print "And how many emails left to reply to: ";
chomp(my $work = <STDIN>);

if ($weather eq "snowing") {
  print "it's snowing, let's go!\n";
} elsif ($weather eq "raining") {
  print "No way, sorry, it's raining so I'm staying in.\n";
} elsif ($temperature < 18) {
  print "Too cold for me!\n";
} elsif ($work > 30) {
  print "Sorry - just too busy.\n";
} else {
  print "Well, why not?\n";
}
print "\n";
