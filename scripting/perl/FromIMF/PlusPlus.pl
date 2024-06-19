#!/bin/perl -w

# bp 40

print "Enter string to have ++ operated on it: ";
chomp(my $alphaNum = <STDIN>);
print "++${alphaNum} makes: " , ++$alphaNum, "\n";
print "${alphaNum}++ makes: " , $alphaNum++, "\n";
exit(0);

print "\n";
$a = "A9"; print "++\$a where \$a = 'A9': ", ++$a, "\n";
$a = "bz"; print "++\$a where \$a = 'bz': ", ++$a, "\n";
$a = "Zz"; print "++\$a where \$a = 'Zz': ", ++$a, "\n";
$a = "z9"; print "++\$a where \$a = 'z9': ", ++$a, "\n";
$a = "9z"; print "++\$a where \$a = '9z': ", ++$a, "\n";
print "\n";
