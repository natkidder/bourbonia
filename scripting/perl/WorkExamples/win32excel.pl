#!/usr/bin/perl -w

use strict;
use Win32::OLE qw(in with);
use Win32::OLE::Const 'Microsoft Excel';

$Win32::OLE::Warn = 3;                                # die on errors...

# get already active Excel application or open new
my $Excel = Win32::OLE->GetActiveObject('Excel.Application')
    || Win32::OLE->new('Excel.Application', 'Quit');  

# open Excel file
my $Book = $Excel->Workbooks->Open("c:/foo/test.xls"); 

# You can dynamically obtain the number of worksheets, rows, and columns
# through the Excel OLE interface.  Excel's Visual Basic Editor has more
# information on the Excel OLE interface.  Here we just use the first
# worksheet, rows 1 through 4 and columns 1 through 3.

# select worksheet number 1 (you can also select a worksheet by name)
my $Sheet = $Book->Worksheets(1);
my $CurrTS = "";
open(F2, ">c:/foo/golf.txt");

foreach my $row (1..15)
{
 foreach my $col (1..2)
 {
  # skip empty cells
  next unless defined $Sheet->Cells($row,$col)->{'Value'};

 # print out the contents of a cell  

  if ($Sheet->Cells($row,1)->{'Value'} gt "") 
  {
    $CurrTS = $Sheet->Cells($row,1)->{'Value'};
  }
  if ($Sheet->Cells($row,2)->{'Value'} =~ /17(\S|\s)*/i) 
  {
    printf F2 
    "At $row the values are %s, %s\n", 
    $CurrTS,
    $Sheet->Cells($row,2)->{'Value'};
  }
 }
}

# clean up after ourselves
$Book->Close;
close(F2);
printf "Open c:/foo/golf.txt\n"
#    printf F2 ("At ($row, 1) the values are %s %d\n",
#     $Sheet->Cells($row,1)->{'Value'}, $Sheet->Cells($row,2)->{'Value'});
