#!/bin/perl

# bp 62

print "\n" . 'unless ($filecount >= 100) {' . "\n";
print '} else {' . "\n\n";

system("ls -l | wc > golf.txt");
my $filecount = 0;
open (F1, "< golf.txt");
while (<F1>) {
  $filecount = $_;
}
print "Enter your file threshold: ";
chomp(my $filethreshold = <STDIN>);

unless ($filecount >= $filethreshold) {
  print "There are less than $filethreshold files in this directory\n"
} else {
  print "There are more than $filethreshold files in this directory\n"
}
print "\n";
