#!/bin/perl -w

# bp 137

use strict;

print "\n\n";
print '   my ($hours, $minutes, $seconds) = secs2hms(3723);' . "\n";
print '   sub secs2hms {' . "\n";
print '     my $seconds = shift;   ## defaults to shifting @_' . "\n";
print '     ...' . "\n";
print '     $seconds %= 60 * 60 ;      ## note the precedence' . "\n";
print '     ...' . "\n";
print '     return ($h, $m, $seconds); ## immediately exits the sub' . "\n";
print '     }' . "\n";
print "\n";

my ($hours, $minutes, $seconds) = secs2hms(3723);
my $hrWord = "hours";
my $hrWord2;
($hrWord2) = $hrWord =~ /^(.{4})/ if $hours = 1;
print "3723 seconds is $hours $hrWord2, $minutes minutes and $seconds seconds\n";
print "\n";

sub secs2hms {
  my ($h, $m);
  my $seconds = shift;   ## defaults to shifting @_
  $h = int( $seconds / ( 60 * 60 ) );
  $seconds %= 60 * 60 ;      ## note the precedence
  $m = int( $seconds / 60 );
  $seconds %= 60;
  return ($h, $m, $seconds);
  print "This statement is never reached\n";
}
