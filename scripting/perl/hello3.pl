#!/bin/perl -w
# bp 298
# hello world (deluxe)

use strict;
use Getopt::Std;

print "\n";
print 'use Getopt::Std;' . "\n";
print 'my %options;' . "\n";
print 'getopts("vhl:", \%options);' . "\n";
print 'if ($options{v}) {' . "\n";
print '  print "Hello World, version 3.\n";' . "\n";
print '  exit;' . "\n";
print '} elsif ($options{l}) {' . "\n";
print '  if ($options{l} eq "French") {' . "\n";
print '    print "Bonjour, tout le monde.\n";' . "\n";
print '  } else {' . "\n";
print '    die "$0: unsupported language\n";' . "\n";
print '  }' . "\n";
print "\n";


my %options;
getopts("vhl:", \%options);

if ($options{v}) {
  print "Hello World, version 3.\n";
  exit;
} elsif ($options{h}) {
  print <<EOF;

$0: Typical Hello World program

Syntax: $0 [-h|-v|-l <language>]

  -h: This help message
  -v: Print version on standard output and exit
  -l: Turn on international language support.
EOF
  exit;
} elsif ($options{l}) {
  if ($options{l} eq "French") {
    print "Bonjour, tout le monde.\n";
  } else {
    die "$0: unsupported language\n";
  }
} else {
  print "Hello, World.\n";
}

print "\n";
