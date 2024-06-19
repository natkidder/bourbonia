#!/bin/perl -w

use strict;
if (scalar @ARGV < 1) {
  print "arg1: APDI PDF file directory\n";
  exit 1;
}
my $ifsDir = shift;
my $file;
my $i = 0;
my (@ary, $catalogFile);
sub InXml;
sub InDirectory;

opendir DH, "$ifsDir" or die "couldn't open the current directory: $!";

while ($_ = readdir(DH)) {
  $file = $_;
  next if $_ eq "." or $_ eq "..";
  if ($_ =~ /pdf$/i) {
    if (!(&InXml($_))) {
      print "File $file not in catalog\n";
      $i++;
    }
  }
}
closedir DH;
print "All directory files in the XML catalog\n" if !$i;

## Now, check whether each line in the XML pertains to the directory

open FI, "< $ifsDir/IMFNAMES.xml" or die "cannot open file $!";  ## XML file catalog
while (<FI>) {
  if ($_ =~ /pdf file=/ ) {
    @ary = split /"/, $_;
    $catalogFile = $ary[1];
    if (!(&InDirectory($catalogFile))) {
      print "Catalog item $catalogFile not in directory\n";
      $i++;
    }
  }
}
close FI;
print "All XML catalog items are files in the directory \n" if !$i;

## subroutines

sub InXml {
  my $filename = shift;
  my $catalogFile;
  my $InCatalog = "";
  my @ary;
  open FI, "< $ifsDir/IMFNAMES.xml" or die "cannot open file $!";  ## XML file catalog
  while (<FI>) {
    if ($_ =~ /pdf file=/ ) {
      @ary = split /"/, $_;
      $catalogFile = $ary[1];
      if (lc($filename) eq lc($catalogFile)) {
        $InCatalog = 1;
      }
    }
  }
  close FI;
  $InCatalog;
}

sub InDirectory {
  my $filename = shift;
  my $InDirectory;
  opendir DH, "$ifsDir" or die "couldn't open the current directory: $!";
  while ($_ = readdir(DH)) {
    next if $_ eq "." or $_ eq "..";
    if ($_ =~ /pdf$/i) {
      if (lc($filename) eq lc($_)) {
        $InDirectory = 1;
      }
    }
  }
  closedir DH;
  $InDirectory;
}


##  <pdf file="20070420_TITLE.pdf" type="EX" date="200705">Title</pdf> 
##  <pdf file="20070420_COPY.pdf" type="EX" date="200705">Copyright Information</pdf> 
##  <pdf file="20070420_NEW.pdf" type="EX" date="200705">New and Revised Data</pdf> 
