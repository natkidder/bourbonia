#!/bin/perl -w

use strict;
use File::Copy;

my $argCnt = @ARGV; print "\$argCnt = $argCnt\n";
my $blankWordFile = "u:/doc1.doc";
my $finalArgs = "";
my $WordProgPath = "c:/program files/microsoft office/office11/winword.exe" ;

#unless ($argCnt) {
#  print "xl.pl: args: Word files to open or create\n";
#  exit 1;
#}
foreach (@ARGV) {
  if ($_ eq "&") {
    print "at \&\n";
    last;
  }
  unless (-e $_) {
    print "File $_ does not exist, would you like to create it? (y) ";
    my $answer = <STDIN>;
    chomp($answer);
    if (lc($answer) ne "n") {
      print "\$answer = $answer\n";  ###
      copy "$blankWordFile","$_" ;
      $finalArgs = $finalArgs . " \"$_\"";
    }
  } else {
  $finalArgs = $finalArgs . " '$_'";
  }
}
print "\$finalArgs = $finalArgs\n";
system("\"c:/program files/microsoft office/office11/winword.exe\"  $finalArgs &");
##system("$WordProgPath $finalArgs);

##"c:/program files/microsoft office/office11/winword.exe" "$@"
##if [ -e "$1" ]; then
##  echo "doc has already been created"
##else
##  echo "doc has not yet been created"
##  cp u:/doc1.doc "$1"
##fi
##"c:/program files/microsoft office/office11/winword.exe" "$@"
