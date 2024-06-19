#! /bin/perl -w
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';

$i = 0;
$Conn = Win32::OLE->new("ADODB.Connection");
$rs =   Win32::OLE->new("ADODB.Recordset");
$DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=EDF_ITTSCB;Data Source=EDFSWN03P;";

##my $SQL = "SELECT Oname FROM tbl_onames WHERE Oname LIKE '135%'";
my $SQL = <<EOF;
SELECT a.ONAME as TSKey, b.*
FROM TBL_ONAMES a, TBL_TSERIES17 b
WHERE a.OID = b.ONAME
AND b.OROWID = 2006
AND (OVALUE11 <> 0 OR OVALUE12 <> 0 OR OVALUE15 <> 0 OR OVALUE16 <> 0 OR OVALUE17 <> 0)
EOF

$Conn->Open($DSN);
$rs->Open($SQL, $Conn, 1, 1);
open FILE, "> c:/foo/golf.txt";
unless (($rs->BOF) && ($rs->EOF)) {
  $rs->MoveLast;$rs->MoveFirst;
  printf "%d \n", $rs->RecordCount;
  printf FILE"Nbr of rows returned: " . $rs->RecordCount . "\n"; 
  print "Press any key to continue: ";
  my $cont = <STDIN>;
  sleep(5);
  until ($rs->EOF) {
    $i += 1;
    print FILE $rs->Fields("TSKey")->Value . "  " . 
               $rs->Fields("OVALUE11")->Value . "  " .  
               $rs->Fields("OVALUE12")->Value . "  " .  
               $rs->Fields("OVALUE15")->Value . "  " .  
               $rs->Fields("OVALUE16")->Value . "  " .  
               $rs->Fields("OVALUE17")->Value . "\n";
    $rs->MoveNext;
  }
##else { printf "No rows returned\n"; }
}
## Closing the database connection
$rs->Close;
$Conn->Close;
close FILE;
