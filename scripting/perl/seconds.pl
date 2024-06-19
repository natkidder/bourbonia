#!/bin/perl -w

# bp 135

use strict;

print "\n\n";
print '   my ($hours, $minutes, $seconds) = secs2hms(3723);' . "\n";
print '   sub secs2hms {' . "\n";
print '     my $seconds = shift;   ## defaults to shifting @_' . "\n";
print '     ...' . "\n";
print '     $seconds %= 60 * 60 ;      ## note the precedence' . "\n";
print '     ...' . "\n";
print '     ($h, $m, $seconds);  ## sub does not exit, but ensure it\'s the last line' . "\n";
print '     }' . "\n";
print "\n";

my ($hours, $minutes, $seconds) = secs2hms(3723);
print "3723 seconds is $hours hours, $minutes minutes and $seconds seconds\n";
print "\n";

sub secs2hms {
  my ($h, $m);
  my $seconds = shift;   ## defaults to shifting @_
  $h = int( $seconds / ( 60 * 60 ) );
  $seconds %= 60 * 60 ;      ## note the precedence
  $m = int( $seconds / 60 );
  $seconds %= 60;
  ($h, $m, $seconds);
#  print "Last line in the sub secs2hms\n";
}
