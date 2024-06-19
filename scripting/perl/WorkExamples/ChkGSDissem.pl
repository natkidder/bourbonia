#! /bin/perl -w
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';

$i = 0;
$Conn = Win32::OLE->new("ADODB.Connection");
$rs =   Win32::OLE->new("ADODB.Recordset");
$DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=EDF_GS_DISSEM;Data Source=EDFVWN01P;";

##my $SQL = "SELECT Oname FROM tbl_onames WHERE Oname LIKE '135%'";
my $SQL = <<EOF;
SELECT a.ONAME as TSKey, b.orowid, b.ovalue17
FROM TBL_ONAMES a, TBL_TSERIES17 b
WHERE a.OID = b.ONAME
and a.oname like '18175%'
order by a.oname, b.orowid
EOF

$Conn->Open($DSN);
$rs->Open($SQL, $Conn, 1, 1);
open FILE, "> c:/foo/golf.csv";
unless (($rs->BOF) && ($rs->EOF)) {
  $rs->MoveLast;$rs->MoveFirst;
  printf "%d \n", $rs->RecordCount;
  printf "Nbr of rows returned: " . $rs->RecordCount . "\n"; 
  print "Press any key to continue: ";
  my $cont = <STDIN>;
  sleep(5);
  until ($rs->EOF) {
    $i += 1;
    print FILE $rs->Fields("TSKey")->Value . "," . 
               $rs->Fields("OROWID")->Value . "," .  
               $rs->Fields("OVALUE17")->Value . "\n";
    $rs->MoveNext;
  }
##else { printf "No rows returned\n"; }
}
## Closing the database connection
$rs->Close;
$Conn->Close;
close FILE;
system("xl.pl c:/foo/golf.csv &");
