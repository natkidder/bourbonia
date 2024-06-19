#! /bin/perl 
use Win32::OLE;
use Win32::OLE::Const 'Microsoft ActiveX Data Objects';

if (scalar(@ARGV) < 5 or $ARGV[0] eq "--help") {
  print "arg1: begin date of range, arg2: end date of range, arg3: start nbr of pub type, arg4: end nbr of pubtype, arg5: filename prefix\n";
  exit 1;
}

my $i = 0;
my $Conn = Win32::OLE->new("ADODB.Connection");
my $rs =   Win32::OLE->new("ADODB.Recordset");
my $svr = "EDFSWN07P";
my $DB = "EDF_AutomatedPrinting";
my $beginDt = shift;
my $endDt = shift;
my $beginPubType = shift;
my $endPubType = shift;
my $FilePref = shift;
my $DSN = "Provider=SQLOLEDB.1;Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=" . $DB . ";Data Source=" . $svr . ";";

my $ColList = <<SELECT;
Id_Auto_Print, Id_PubType, PubName, Entered_Dates, Subject_Matter, Run, Priority, Email_To, Email_Cc, Email_Subject, Email_Message, cast(Update_date as varchar(20)) as Update_Date
SELECT

my @Cols = split(",",$ColList);
my $SQL = <<EOF;
  SELECT $ColList
FROM         dbo.tblProductionDates a, dbo.tblPubType b
WHERE     a.Id_PubType = b.PubID
AND (CAST(Entered_Dates AS DateTime) BETWEEN '$beginDt' AND '$endDt')
AND       Id_PubType BETWEEN $beginPubType AND $endPubType
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
