#!/bin/perl -w

use strict;

if (scalar(@ARGV) < 2) {
  die("arg1: source file, arg2: dest file\n");
}
my $infile = shift;
my $outfile = shift;
my @lines;   my $cr = chr(13);   my $lf = chr(10);  my @output;   my @output2;    my $i=0;  my $j=0;

open INFILE, "<", $infile || die("could not open $infile\n");

 
while (<INFILE>) {   ##$_ =~ s/$cr//;   $_ =~ s/$lf//;   
    push(@lines,$_);   
}  
close INFILE;

push (@output, "<html>\n<head>\n");
push (@output, "<style>\n.blue { background-color:#EFF1F1 }\n.white { background-color:#FEFEFE }\n</style>\n");
push (@output, "</head>\n<body><code>\n");
foreach my $line (@lines)  {
    $j++;
    $line =~ s/<b>//;   $line =~ s/<\/b>//;
    $line =~ s/</&lt;/g;   $line =~s/>/&gt;/g;
#    $line =~ s/ /&nbsp;/g;
    if ($line =~ m/^[0-9]{5,6}\t\S{1,20}\t/i) {  
        $i++;

        ##print "$line\n"; ####
        if ($i % 2 == 0)  {  
            $line = "<div class=\"blue\">" . $line;
        } else { 
            $line = "<div class=\"white\">" . $line;
        }
        if ($i > 1) { $line = "</div>" . $line;  }
        ##print "$line\n"; ####
        $line =~ s/e\"\>/e\"><br><b>Defect ID: <\/b>/;
        $line =~ s/\t/$lf<p><b>Detected By: <\/b>/;
        $line =~ s/\t/$lf<p><b>Assigned To: <\/b>/;
        $line =~ s/\t/$lf<p><b>Detected in Test Phase: <\/b>/;
        $line =~ s/\t/$lf<p><b>Test Environment: <\/b>/;
        $line =~ s/\t/$lf<p><b>Status: <\/b>/;
        $line =~ s/\t/$lf<p><b>Summary: <\/b>/;
    } elsif ($line =~ m/^.{0,30}Issue:/i  ||  $line =~ m/^.{5,50}201\d:/  ||  $line =~ m/^.{0,30}Result:/i  ||  
             $line =~ m/^.{0,20}Reproduce:/  ||  $line =~ m/^Attachments:/   ||   $line =~ m/^Note:/i  ||  
             $line =~ /^.{0,10}Message:/i )  {
        ##print $line;  ####
        $line =~ s/^/\<p\>\<b\>/;
        $line =~ s/:/:\<\/b\>/;
        $line =~ s/$lf/$lf<br>/;
        $line =~ s/\"$lf/$lf/;
    } elsif ($line =~ m/\_{39,41}.*$/)  {
        ##print "$j $line\n";   ####
        $line =~ s/^.*$//;
    }
    if ($line !~ m/^.+$lf<br>/  &&  $line !~ m/<p>/  &&  $line !~ m/<br>/) { $line =~ s/$lf/<br>/; }
    if ($line =~ /<br>.*<br>/ || $line =~ /<br>.<p>/) {  $line =~ s/<br>//; }
    push (@output,$line);        
}
push (@output,"</div>\n<code></body>\n</html>\n");

foreach my $line (@output)  {
#    if ($line !~ m/^.+$lf<br>/  &&  $line !~ m/<p>/  &&  $line !~ m/<br>/) { $line =~ s/$lf/<br>/; }
#    if ($line =~ /<br>.*<br>/ || $line =~ /<br>.<p>/) {  $line =~ s/<br>//; }

#    $line =~ s/<br>//i;
#    $line =~ s/<br><p>/<br>/i;
    if (substr($line,0,4) ne "<br>")  {  
        push (@output2,$line);
    }
}

open OUTFILE, ">", $outfile;
foreach my $output (@output2)  {
    print OUTFILE $output;
}
close OUTFILE;
print "output in   $outfile\n";


#======================================================================
__END__

