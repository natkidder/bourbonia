#! /bin/perl -w
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';
use DBI;
use DBD::Oracle;

$i = 0;
$Conn = Win32::OLE->new("ADODB.Connection");
$rs =   Win32::OLE->new("ADODB.Recordset");
$DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=EDF_RE_TEST_QA;Data Source=EDFSWN04P;";

my $SQL = "SELECT Oname FROM tbl_onames WHERE Oname LIKE '135%'";

$Conn->Open($DSN);
$rs->Open($SQL, $Conn, 1, 1);
unless (($rs->BOF) && ($rs->EOF))
  {
  $rs->MoveLast;$rs->MoveFirst;
  printf "%d \n", $rs->RecordCount;
  sleep(5);
  until ($rs->EOF)
    {
    $i += 1;
    print $rs->Fields("Oname")->Value . "\n";
    $rs->MoveNext;
    }
  }
## Closing the database connection
$rs->Close;
$Conn->Close;
