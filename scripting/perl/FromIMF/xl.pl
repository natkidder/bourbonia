#!/bin/perl -w

use strict;
use File::Copy;

my $argCnt = @ARGV; print "\$argCnt = $argCnt\n";
my $blankExcelFile = "u:/book1.xls";
my $finalArgs = "";
my $excelProgPath = "c:/program files/microsoft office/office11/excel.exe" ;

unless ($argCnt) {
  print "xl.pl: args: Excel files to open or create\n";
  exit 1;
}
foreach (@ARGV) {
  unless (-e $_) {
    print "File $_ does not exist, would you like to create it? (y) ";
    my $answer = <STDIN>;
    chomp($answer);
    if (lc($answer) ne "n") {
      print "\$answer = $answer\n";  ###
      copy "$blankExcelFile","$_" ;
      $finalArgs = $finalArgs . " \"$_\"";
    }
  } else {
  $finalArgs = $finalArgs . " '$_'";
  }
}
print "\$finalArgs = $finalArgs\n";
system("\"c:/program files/microsoft office/office11/excel.exe\"  $finalArgs &");
##system("$excelProgPath $finalArgs);



##if ( -e "$1" ); then 
##  echo "$@: file will be opened with Excel"
##else
##  echo "$@: file not yet created, will create a blank one"
##  cp u:/book1.xls "$1"
##fi
##"c:/program files/microsoft office/office11/excel.exe" "@ARGV"
