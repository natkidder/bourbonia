#! /bin/perl 
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';

if (scalar(@ARGV) < 6) {
  print "ChkObs.pl: arg1: server, arg2: database, arg3: tskey regex, \narg4: earliest year, arg5: latest year, arg6: filename prefix\n";
  exit 1;
}

my $i = 0;
my $Conn = Win32::OLE->new("ADODB.Connection");
my $rs =   Win32::OLE->new("ADODB.Recordset");
my $svr = shift; ###"EDFSWN05D";
my $DB = shift; ###"EDF_AutomatedPrinting_QA";
my $oname = shift;
my $yr1 = shift;
my $yr2 = shift;
my $FilePref = shift;
my $DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=" . $DB . ";Data Source=" . $svr . ";";

my $ColList = "a.ONAME, c.ConsolidateMethod, c.HowToConsolidateOperator, c.HowToConsolidateRules, c.OFreq, c.HtcMQAFreq, c.DateRangeOfConsolidationType, c.DateRangeOfConsolidationStart, c.DateRangeOfConsolidationEnd, c.FormulaText, OROWID, OVALUE1, OVALUE2, OVALUE3, OVALUE4, OVALUE5, OVALUE6, OVALUE7, OVALUE8, OVALUE9, OVALUE10, OVALUE11, OVALUE12, OVALUE13, OVALUE14, OVALUE15, OVALUE16, OVALUE17";
my @Cols = split(",",$ColList);
my $SQL = <<EOF;

  SELECT $ColList
FROM TBL_ONAMES a, TBL_TSERIES17 b, tbl_ODPs c
WHERE a.OID = b.ONAME and a.oid = c.oid
AND a.ONAME LIKE '$oname'
AND b.OROWID >= $yr1 AND b.OROWID <= $yr2
AND c.ConsolidateMethod <> 'DNC' and c.HowToConsolidateOperator <> 'dnc' 
AND 
(
((OVALUE1 <> 0 AND OVALUE2 <> 0 AND OVALUE3 <> 0) AND OVALUE13 IS NULL)
OR 
((OVALUE4 <> 0 AND OVALUE5 <> 0 AND OVALUE6 <> 0) AND OVALUE14 IS NULL)
OR 
((OVALUE7 <> 0 AND OVALUE8 <> 0 AND OVALUE9 <> 0) AND OVALUE15 IS NULL)
OR 
((OVALUE10 <> 0 AND OVALUE11 <> 0 AND OVALUE12 <> 0) AND OVALUE16 IS NULL)
OR 
((OVALUE13 <> 0 AND OVALUE14 <> 0 AND OVALUE15 <> 0 AND OVALUE16 <> 0) AND OVALUE17 IS NULL)
)

EOF

my $refCols = \@Cols;
my @Cols2 = LastWord($refCols);
for (@Cols2) { print "  " . $_ . "\n"; } ####

print $svr . ", " . $DB . ":\n";  ####
print $SQL . "\n";  ####
$Conn->Open($DSN);
$rs->Open($SQL, $Conn, 1, 1);
open FILE, "> c:/foo/$FilePref.csv";
print FILE $ColList . "\n\n";

unless (($rs->BOF) && ($rs->EOF)) {
  $rs->MoveLast;$rs->MoveFirst;
  printf "Nbr of rows returned: " . $rs->RecordCount . "\n"; 
  unless ($rs->RecordCount) {
    print "SQL statement executed improperly\n";
    goto CLEANUP; } 
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
    $rs->MoveNext;
  }
##else { printf "No rows returned\n"; }
}

print FILE "\n" . $svr . "," . $DB . "\n";  
my $SQL2 = $SQL;
$SQL2 =~ s/\n/\"\n"/g;
$SQL2 = '"' . $SQL2 . '"';
print FILE $SQL2;
system("xl.pl c:/foo/$FilePref.csv &");

## Closing the database connection
CLEANUP:
$rs->Close;
$Conn->Close;
close FILE;

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
