#!/bin/perl -w

# User enters string, reg expression to subst, then new string

print "Enter str to perform subst on: ";
my $string = <STDIN>;
chomp($string);

print "Enter reg expr to substitute: ";
my $regExpr = <STDIN>;
chomp($regExpr);

print "Enter new string: ";
my $newStr = <STDIN>;
chomp($newStr);
print "\$newStr = $newStr\n\n";

$string =~ s/$regExpr/$newStr/g ;

print "new string: $string\n";
