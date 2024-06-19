#!/bin/perl -w
# bp 265

use strict;

print "\n";
print 'my $a = [];' . "\n";
print 'my $b = {};' . "\n";
print 'my $c = \1;' . "\n";
print 'my $d = \$c;' . "\n";
print 'my $e = \#;' . "\n";
print 'print "\$a,   []   or $a, is a		", ref($a), " reference\n";' . "\n";
print 'print "\$b,   {}   or $b, is a		", ref($b), " reference\n";' . "\n";
print 'print "\$c,   \\1   or $c, is a		", ref($c), " reference\n";' . "\n";
print 'print "\$d,   \\\$c   or $d, is a		", ref($d), " reference\n";' . "\n";
print 'print "\$e,   \\#   or $e, is a		", ref($e), " reference\n";' . "\n";
print "\n";

my $a = [];
my $b = {};
my $c = \1;
my $d = \$c;
my $e = \#;
print "\$a,   []   or $a, is a		", ref($a), " reference\n";
print "\$b,   {}   or $b, is a		", ref($b), " reference\n";
print "\$c,   \\1   or $c, is a		", ref($c), " reference\n";
print "\$d,   \\\$c   or $d, is a		", ref($d), " reference\n";
print "\$e,   \\#   or $e, is a		", ref($e), " reference\n";

print "\n";
