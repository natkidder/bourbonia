#!/bin/perl -w
# bp 216

use strict;
use lib "/cygdrive/u/perl/examples";

my $glob = shift;
if (not $glob) {
  print FileOnly($0) . ": arg1: globbing expression\n";
  exit;
}
print "\$glob = $glob\n";
  
print "Contents of the current directory:\n";

open FILE, "> u:/perl/examples/golf.pm";
print FILE <<EOF;
#!/bin/perl
package golf;

sub FileFind {
  foreach (<$glob>) {
##foreach (<*>) {
    next if $_ eq "." or $_ eq "..";
    print $_, " " x (30 - length($_));
    print "d" if -d $_;
    print "r" if -r _;
    print "w" if -w _;
    print "x" if -x _;
    print "o" if -o _;
    print "\t";
    print -s _ if -r _ and -f _;
    print "\n";
  }
}

1;
EOF

print "\n";

sub FileOnly {
  my $FullPath = shift;
  my @Path = split("/", $FullPath);
  my $File = $Path[$#Path];
  return $File;
}
