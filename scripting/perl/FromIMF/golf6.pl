#! /bin/perl 
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';

if (scalar(@ARGV) < 3 or $ARGV[0] eq "--help") {
  print "ChkObs.pl: arg1: server, arg2: database, arg3: TS Key regex, arg4: filename prefix\n";
  exit 1;
}

my $i = 0;
my $Conn = Win32::OLE->new("ADODB.Connection");
my $rs =   Win32::OLE->new("ADODB.Recordset");
my $svr = shift; ###"EDFSWN05D";
my $DB = shift; ###"EDF_AutomatedPrinting_QA";
my $tskey = shift;
my $FilePref = shift;
my $DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=" . $DB . ";Data Source=" . $svr . ";";

my $ColList = <<EOF;
'',n.OID, n.OName, n.IsDeleted, n.ODependents, n.OComponents, n.IsAlias, n.HasAliases, n.RealOID, n.IsVersionName, n.HasVersionNames, n.IsAlternateName, n.HasAlternateNames, n.SyncID, o.OID, o.SyncID, o.Description, o.IsReadOnly, o.FormulaText, o.FormulaCompileText, o.FormulaFunctionList, o.FormulaOperatorList, o.FormulaRequireFullDateRange, o.FormulaLOn, o.OFreq, o.PFU, o.OBaseIndex, o.SFY, o.HowToUpdateOperator, o.HowToUpdateRules, o.DateRangeOfUpdateType, o.DateRangeOfUpdateStart, o.DateRangeOfUpdateEnd, o.HtcFreq, o.HtcMQAFReq, o.FirstDayOfWeek, o.FirstWeekOfYear, o.DateRangeOfValidityType, o.DateRangeOfValidityStart, o.DateRangeOfValidityEnd, o.ConsolidateMethod, o.DateRangeOfConsolidationType, o.DateRangeOfConsolidationStart, o.DateRangeOfConsolidationEnd, o.HowToConsolidateOperator, o.HowToConsolidateRules, o.HowToAssignOperator, o.HowToAssignRules, o.IgnoreMissingComponents, o.IgnoreMissingValues, o.DateRangeOfCalculationType, o.DateRangeOfCalculationStart, o.DateRangeOfCalculationEnd, o.AutoDistributeOn, o.IsLink, o.LinkedToDBName, o.LinkedToOName, o.Unit, o.Scale, o.[Precision], u.OID, u.SyncID, u.DomainName, u.CountryCode, u.Topic, u.Source, u.PartnerCountryCode, u.SubjectMatter, u.Datatype, u.NationalDescriptor, u.Mnemonic, u.AccessCode 
EOF
my @Cols = split(",",$ColList);
my $SQL = <<EOF;
  SELECT $ColList
FROM tbl_ODPS o, tbl_UDPs u, tbl_Onames n
WHERE o.oid = n.oid AND u.oid = n.oid
and (o.description like '%price%' or o.description like '%cpi%')
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
      $colName =~ s/\[//g;
      $colName =~ s/\]//g;
      if ($colName =~ /[^'"]/) {
##        print '$rs->Fields(' . $colName . ')->Value . ","' . "\n";  ####
        print FILE '"' . $rs->Fields($colName)->Value . '",'
      } else {
        print FILE $colName . ',';
      }
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
