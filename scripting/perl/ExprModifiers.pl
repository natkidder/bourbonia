#!/bin/perl -w

# bp 62

print 'print "less than $filethreshold files in this directory\n" if $filecount < $filethreshold;' . "\n";
print 'print "more than $filethreshold files in this dir\n" unless $filecount < $filethreshold;' . "\n";
print 'print "files exist in this directory\n" if $filecount;' . "\n";
print "\n";

system("command ls | wc | cut -c0-11 > golf.txt");
my $filecount = 0;
open (F1, "< golf.txt");
while (<F1>) {
  $filecount = $_;
}
print "Enter your file threshold: ";
chomp(my $filethreshold = <STDIN>);

print "less than $filethreshold files in this directory\n" if $filecount < $filethreshold;
print "more than $filethreshold files in this dir\n" unless $filecount < $filethreshold;
print "files exist in this directory\n" if $filecount;
print "\n";
