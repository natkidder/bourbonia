#!/bin/perl
# bp 20

print "\nprint <<EOF;\n";
print "\n";
print "This is a here-document.  It starts on the line after the two arrows, \n";
print "and it ends when the test following the arros if found at the beginning \n";
print "of a line, like this:\n";
print "\n";
print "EOF\n";

print <<EOF;

This is a here-document.  It starts on the line after the two arrows, 
and it ends when the test following the arros if found at the beginning 
of a line, like this:

EOF

