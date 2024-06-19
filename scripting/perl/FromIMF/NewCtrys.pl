#!/bin/perl -w

# bp 181

use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';
use strict;

my (@cols, $ctryCode, $prevCtryCode);

my $DataFile = shift;
if (not $DataFile) {
  print FileOnly($0) . ": arg1: data file\n";
  exit;
}
  
open(FILE, '<', $DataFile) or die $!;

while (<FILE>) {
  @cols = split " ", $_;
  $ctryCode = @cols[0];
  if $ctryCode <> $prevCtryCode {
    if !(InCtryTbl($ctryCode)) {
      ;
  }
  print ": $_";
}

close FILE;

sub FileOnly {
  my $FullPath = shift;
  my @Path = split("/", $FullPath);
  my $File = $Path[$#Path];
  return $File;
}

sub InCtryTbl  {
  my $i = 0;
  my $Conn = Win32::OLE->new("ADODB.Connection");
  my $rs =   Win32::OLE->new("ADODB.Recordset");
  my $DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;" . 
            "Persist Security Info=False;Initial Catalog=EDF_ITTSCB;" . 
            "Data Source=EDFSWN03P;";

  my $SQL = <<EOF;
  EOF

  $Conn->Open($DSN);
  $rs->Open($SQL, $Conn, 1, 1);
  unless (($rs->BOF) && ($rs->EOF)) {
    $rs->MoveLast;$rs->MoveFirst;
    $i = $rs->RecordCount;
    }
  }
## Closing the database connection
  $rs->Close;
  $Conn->Close;

  $i;
}
