#!/bin/perl -w

# bp 62

print "\n". 'die "you skipped the step" unless $nbr;' . "\n\n";

printf "enter a number or string: ";
chomp(my $nbr = <STDIN>);
die "you skipped the step, hence abort\n" unless $nbr;
if ($nbr) {
  print "your program reached this point\n"
}
