#!/bin/perl 

use strict;

my $EarlyFile = "";
my $LateFile = "";
my $line = "";
## ASSUMES that the country name, and only the ctry name, is in the 1st 20 chars of a line
my $LenOfCtry = 20;
my (@ef, @lf, $ef, $lf);
my ($InEF, $NotInEF, @NotInEF);
my $AllInEF = 1;

$EarlyFile = EnterFileName("\nEnter the name of the earlier Italy Monthly file: ");
$LateFile =  EnterFileName("\nEnter the name of the later Italy Monthly file: ");

@ef = CreateArray($EarlyFile);
@lf = CreateArray($LateFile);

print "\nCountries in $LateFile that are not in $LateFile:\n\n";
for $lf (@lf) {
  $InEF = 0;
  for $ef (@ef) {
    $InEF = 1 if $lf eq $ef; 
  }
  unless ($InEF) { 
    print "Country $NotInEF new for Italy Monthly, for $LateFile\n";
    $AllInEF = 0;
  }
}
print "All countries for Italy Monthly for $LateFile are also in $EarlyFile\n\n";

sub EnterFileName {
  my $Msg = shift;
  print $Msg;
  my $Filename = <STDIN>;
  chomp($Filename);
  if (!$Filename) {
    print "no entry--exit\n";
    exit 1;
  } else {
    if (!-e $Filename) {
      print "file $Filename does not exist\n";
      return;
    }
  }
  $Filename;
}

sub CreateArray {
  if (!$_[0]) { print "CreateArray arg1: source file\n"; return }
  my ($ctry,$prevCtry, @wf);
  open RF, "<", shift;  #####$_[0];
  while ($line = <RF>) {
    $ctry = substr($line,0,$LenOfCtry);
    $ctry =~ tr/ //d;
    push(@wf, $ctry) if $ctry ne $prevCtry;
    $prevCtry = $ctry;
  }
  @wf = sort @wf;
  @wf;
}
