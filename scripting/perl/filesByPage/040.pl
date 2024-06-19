#!/bin/perl -w

# bp 40

while (1==1) {
  print "('exit' to leave)\n";
  print "Enter string to augment: ";
  chomp(my $str = <STDIN>);
  last if $str eq "exit";
  print "++$str", " == ", ++$str, "\n";
}
exit 0;


print "\n";
$a = "A9"; print "++\$a where \$a = 'A9': \t\t\t", ++$a, "\n";
$a = "bz"; print "++\$a where \$a = 'bz': \t\t\t", ++$a, "\n";
$a = "Zz"; print "++\$a where \$a = 'Zz': \t\t\t", ++$a, "\n";
$a = "z9"; print "++\$a where \$a = 'z9': \t\t\t", ++$a, "\n";
$a = "9z"; print "++\$a where \$a = '9z': \t\t\t", ++$a, "\n";
print "\n";
