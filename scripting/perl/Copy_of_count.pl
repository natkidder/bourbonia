#!/bin/perl -w

# bp 123

use strict;

print "\n\n";
print 'my @names = qw(' . "\n";
print '	John	Sue	Larry' . "\n";
print '	Mary	John	Mary' . "\n";
print '	Larry	John	Joe' . "\n";
print '	Lisa	John	Mary' . "\n";
print ');' . "\n";
print "\n";
print 'my %count;' . "\n";
print '' . "\n";
print 'foreach (@names) {' . "\n";
print '  if (exists $count{$_}) {' . "\n";
print '    $count{$_}++;' . "\n";
print '  } else {' . "\n";
print '    $count{$_} = 1;' . "\n";
print '  }' . "\n";
print '}' . "\n";
print '' . "\n";
print 'foreach (keys %count) {' . "\n";
print '  print "$_ occurs $count{$_} time(s) \n";' . "\n";
print '}' . "\n";
print "\n";

print 'Press <Ent> to cont'; my $pause = <STDIN>;
print "\n";

my @names = qw(
	John	Sue	Larry
	Mary	John	Mary
	Larry	John	Joe
	Lisa	John	Mary
);

my %count;

foreach (@names) {
  if (exists $count{$_}) {
    $count{$_}++;
  } else {
    $count{$_} = 1;
  }
}

foreach (keys %count) {
  print "$_ occurs $count{$_} time(s) \n";
}

print "\n";
