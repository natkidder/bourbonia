#! /bin/perl 
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';

$i = 0;
$Conn = Win32::OLE->new("ADODB.Connection");
$rs =   Win32::OLE->new("ADODB.Recordset");
$svr = "EDFSWN04P";
$DB = "EDF_MB_TEST_QA";
$DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=" . $DB . ";Data Source=" . $svr . ";";

##my $SQL = "SELECT Oname FROM tbl_onames WHERE Oname LIKE '135%'";
my $ColList = "a.ONAME, b.ovalue12, b.ovalue16, b.ovalue17";
my @Cols = split(",",$ColList);
my $SQL = <<EOF;
SELECT $ColList
FROM TBL_ONAMES a, TBL_TSERIES17 b 
WHERE a.OID = b.ONAME 
and (a.oname like '%11260C%') 
AND b.OROWID = 2006 
EOF

my $refCols = \@Cols;
my @Cols2 = LastWord($refCols);
print "\@Cols2: \n"; ####
for (@Cols2) { print "  " . $_ . "\n"; } ####

print $svr . ", " . $DB . ":\n";  ####
print $SQL . "\n";  ####
#exit 1;  ####
$Conn->Open($DSN);
$rs->Open($SQL, $Conn, 1, 1);
open FILE, "> c:/foo/golf.csv";
print FILE $ColList . "\n";

unless (($rs->BOF) && ($rs->EOF)) {
  $rs->MoveLast;$rs->MoveFirst;
  printf "Nbr of rows returned: " . $rs->RecordCount . "\n"; 
  print "Press any key to continue: ";
  my $cont = <STDIN>;
  sleep(5);
  until ($rs->EOF) {
    $i += 1;
    foreach my $colName (@Cols2) {
      $colName =~ s/ //g;
##      print '$rs->Fields(' . $colName . ')->Value . ","' . "\n";  ####
      print FILE '"' . $rs->Fields($colName)->Value . '",'
    }
    print FILE "\n";
##    print FILE $rs->Fields("TSKey")->Value . "," . 
##               $rs->Fields("OROWID")->Value . "," .  
##               $rs->Fields("OVALUE17")->Value . "\n";
    $rs->MoveNext;
  }
##else { printf "No rows returned\n"; }
}
## Closing the database connection
$rs->Close;
$Conn->Close;
close FILE;
system("xl.pl c:/foo/golf.csv &");

sub LastWord {
  my $aryRef = shift;
  my @ary = @$aryRef;
  my ($i, $elem, $elem2, $elem3);
  print "LastWord: spaces in \@ary:\n";  ####
  for $i (0..$#ary) {
    my @ary2 = split(" ", $ary[$i]);
    $elem2 = $ary2[$#ary2];
    $elem2 =~ s/\./:/g;
    my @ary3 = split(/:/,$elem2);
    $elem2 = $ary3[$#ary3];
    $ary[$i] = $elem2;
  }
  @ary;
}

###and (a.oname like '%IUMAED3A%' or a.oname like '%IUMAAJNB%') 
##11260C...I...{Z}
