#!/bin/perl -w
# bp 300
# Hello World (Deluxe) - with long flags

use strict;

print "\n";
print 'use Getopt::Long;' . "\n";
print 'GetOptions(\%options, "language:s", "help", "version");' . "\n";
print 'if ($options{version}) {' . "\n";
print '  print "Hello World, version 3, with long options.\n";' . "\n";
print '  exit;' . "\n";
print '} elsif ($options{language}) {' . "\n";
print '  if (lc($options{language}) eq "french") {' . "\n";
print '    print "Bonjour, tout le monde.\n";' . "\n";
print '  } else {' . "\n";
print '    die "$0: unsupported language\n";' . "\n";
print '  }' . "\n";
print "\n";


use Getopt::Long;

my %options;
GetOptions(\%options, "language:s", "help", "version");

if ($options{version}) {
  print "Hello World, version 3, with long options.\n";
  exit;
} elsif ($options{help}) {
  print <<EOF;

$0: Typical Hello World program

Syntax: $0 [--help|--version|--language=<language>]

  --help    : This help message
  --version : Print version on standard output and exit
  --language: Turn on international language support.

EOF
  exit;
} elsif ($options{language}) {
  if (lc($options{language}) eq "french") {
    print "Bonjour, tout le monde.\n";
  } else {
    die "$0: unsupported language\n";
  }
} else {
  print "Hello, world.\n";
}

print "\n";
