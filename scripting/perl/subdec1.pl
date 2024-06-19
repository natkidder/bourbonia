#!/bin/perl -w

# bp 131

use strict;


print "\n\n";
print 'sub setup;' . "\n";
print 'setup;' . "\n";
print "\n";
print 'sub setup {' . "\n";
print '  print "This is some program, version 0.1\n";' . "\n";
print '}' . "\n";
print "\n";


sub setup;
setup;
print "\n";

sub setup {
  print "This is some program, version 0.1\n";
}

print "Press <Ent> to cont: "; my $cont = <STDIN>;
print "\n================================\n";

print 'use subs qw(note note2);' . "\n";
print 'note;' . "\n";
print 'note2;' . "\n";
print "\n";

use subs qw(note note2);
note;
note2;
sub note { print "generic note\n"; }
sub note2 { print "generic note #2\n"; }
print "\n";

print "Press <Ent> to cont: "; $cont = <STDIN>;
print "\n================================\n";

print 'note3();' . "\n";
print "\n";
note3();
sub note3 { print "generic note #3\n"; }
print "\n";

print "Press <Ent> to cont: "; $cont = <STDIN>;
print "\n================================\n";

print '&note4;' . "\n";
print "\n";
&note4;
sub note4 { print "generic note #4\n"; }
print "\n";
