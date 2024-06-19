#!/bin/perl -w

# bp 62

print "\n". 'die "you entered zero\n" unless $nbr;' . "\n\n";

print "enter a number or string: ";
chomp(my $nbr = <STDIN>);
die "you skipped the step, hence abort\n" unless $nbr;
if ($nbr) {
  print "your program reached this point\n"
}
