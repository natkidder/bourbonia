#!/bin/perl -w
# bp 244

print "this program illustrates autovivification.\n\n";

use strict;

my @chessboard;
my @back = qw(R N B Q K B N R);
foreach (0..7) {
  $chessboard[0]->[$_] = "W" . $back[$_]; # white back row
  $chessboard[1]->[$_] = "WP";            # white pawns
  $chessboard[6]->[$_] = "BP";            # black pawns
  $chessboard[7]->[$_] = "B" . $back[$_]; # black back row
}

while (1) {
  # Print board
  foreach my $i (reverse (0..7)) {   # Row
    foreach my $j (0..7) {           # Column
      if (defined $chessboard[$i]->[$j]) {
        print $chessboard[$i]->[$j];
      } elsif ( ($i % 2) == ($j % 2) ) {
        print "..";
      } else {
        print "  ";
      }
      print " ";  # end of cell
    }
    print "\n";   # end of row
  }

  print "\nStarting square [x,y]: ";
  my $move = <>;
  last unless ($move =~ /^\s*([1-8]),([1-8])/);
  my $startx = $1-1;
  my $starty = $2-1;

  unless (defined $chessboard[$starty]->[$startx]) {
    print "There's nothing on that square\n";
    next;
  }
  print "\nEnding square [x,y]: ";
  $move = <>;
  last unless ($move =~ /([1-8]),([1-8])/);
  print "last last of while\n"; #####
  my $endx = $1-1;
  my $endy = $2-1;

  # Put starting square on ending square
  $chessboard[$endy]->[$endx] = $chessboard[$starty]->[$startx];

  # Remove from old square
  undef $chessboard[$starty]->[$startx];

}
