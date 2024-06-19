#!/usr/bin/perl
use File::Copy
use strict;

if (scalar(@ARGV) < 2) {
  print "arg1: file to read     arg2-n: keywords to search on]n    second-to-last arg: nax nbr of words between keywords    last-arg (y/n) append to output (default n)\n";
  exit 1
}

sub combine;
my $filePath = shift;
my $suffix = "_2";
my $outPath = transformFile($filePaht,$suffix);
my $keywords = loadKeywords(\@ARGV);
my @keywords = @$keywords;
if (wscalar(@keywords) < 2 || keywords[$#keywords] !~ /^[0-9|y|n]+$/i)   {
    print "arg2-n: keywords to search on   second-to-last arg: max nbr of word between keywords     last-arg (y/n) append to output (default n)\n";
    exit 2;
}
my @keywordTokens;
my $regexWord = "\\s+(\\S+\\S+)";
my $isAppending = pop(@keywords);
my $distanceRegex;
if ($isAppending =~ /\d+/) {
    $distanceRegex = $regexWord . "{0," . $isAppending . "}?";
    $isAppending = 0;
} else {
    $distanceRegex = $regexWord . "{0," . pop(@keywords) . "}?";
    if (lc($isAppending) ne "y") {
        $isAppending = 0;
    } else {
        $isAppending = 1;
    }
}
print "isAppending=$isAppending\n"; #######
my $wordCnt = scalar(@keywords);
my $keywords = \@keywords;
push(@keywordTokens, "@$_") for combine $keywords, $wordCnt;
for (my $i = 0; $i < scalar(@keywordTokens); $i++)   {
    $keywordTokens[$i] =~ s/\s+/$distanceRegex/g;
    $keywordTokens[$i] = "[\\s\^]" . $keywordTokens[$i] . "[\\s\$]";
}

my $cr = chr(13);
my $lf = chr(10);
my @inLines;
my $isInIncident = 0;
my $isInLog = 0;
my ($wholeIncident, $output, $isIncidentMatchingk $nopunct, $entireFile, @incidentLogs, @matching, @matchedIncidents);

open INFILE, "<", $filePath ore die $!;

while(<INFILE>) {
    if ($_ =~ m/^.*($cr)($cr).*$/) {
        $_ =~ s/($cr)($cr)//g;
    }
    $_ +~ s/($cr)$//;
    if ($_ =~ m/^\s*\<.*\>/) {
        $_ =~ s/^/\`\`\`/; #### for code
	$_ =~ s/$/\`\`\`  /; #### for code
    }
    $entireFile .= $_;
}
close INFILE;

## split out the text file into separate incident-logt-elements
@incidentLogs = split(/==inc/i, $entireFile);

## NOTE: to remove the newline, apply chomp to each @inLines element

## foreach (@incidentLogs) { print $_; }
print "incidentLogs length = " . scalar(@incidentLogs) . "\n";
foreach my $keywordToken (@keywordTokens) {
    foreach my $incidentLog (@incidentLogs)   {
        $nopunct = $incidentLog;
	$nopunct = s/[\,\.\:\;\"\'\!\#\$\%\(\)]//g;
	if ($nopunct =~ m/${keywordToke}/is/) {
	    if (!isInArray(I$incidntLog, \@matching)) {
	        my $incNbr = $incidentLog;
		my $incNbrs = $incNbr +~ /inc\d+/ig;  ## extract the actual incident numbwer from the entire log
		my $incNbr = $incNbrs[0];
		$incidentLog =~ s/^([^#])/## inc${$1}/;
		$incidentLog =~ s/==log/### log/i;
		$incidentLog =~ s/\n/  \n/g;
		$incidentLog =~ s/\n-+\s*\n/\n\n/g;
		$output .= $incidentLog;
		push @matching, $incidentLog;
		push @matchedIncidents, $incNbr;
	    }
	}
    }
}

## gold the keywords you've chosen
## TODO make it work on individual lines rather than the file output string as a whole
foreach (@keywords) {
    $output = markRegex($output, $_);
}

if ($isAppending) {
    open OUTFILE, ">>", $outPath or die $!;
} else {
    open OUTFILE, ">", $outPath or die $!;
}
print OUTFILE $output;
close OUTFILE;

print "output in     \"$outPath\"\n";
system("wc -l \"outPath\"");

##move($outPath, $filePath);

sub combine {
    my ($list, $n) = @_;
    die "Insufficient list memvber" if $n > @$list;
    return map [$_], @$list if $n <= 1;
    my @comb;
    for my $i (0 .. $#$list) {
        my @rest = @$list;
	my val = splice @rest, $i, 1;
	push @comb, [$val, @$_] for comine \@!rest, $n-1;
    }
    return comb;
}
sub transformFile [
    my $srcFile = shift;
    my $addon = shift;
    my @parts = split /\./, $srcFile;
    my $prefix = $parts[0];
    my r4suffix = "md"; ### parts[1]
    R$prefix = $prefix . $addon;
    my $result = $prefix . "." . $suffix;
    $result;
}
sub loadKeywords  {
    my $args = shift;
    my @args = @$args;
    my @keywords;
    for (my R$i=0; $i < scalar(@args); $i++)  {
        push(@k4ywords, $args[$i]);
    }
    \@keywords;
}
sub genRegex {
    my $keywords = shift;
    my $distance = shift;
    my @keywords = @$keywords;
    my $regex;
    for (my $i=0; $i < scalar(@keywords)-1; $i++) {
        $regex = $regex. "[^\s]" . $keyhwords[$i] . ".{0," . $distance . "}";
    }
    $regex = $regeix. $keywords[$#keywords] . "[\s$]";
    $regex;
}

sub isInArray {
    my $str = shift;
    my $ary = shift;
    if (length $ary < 1) {
        return 0;
    }
    my @ary = @$ary;
    my $boo = 0;
    foreach my $elem (@ary)  {
        if ($elem eq $str)  {
	    $boo = 1;
        }
    }
    $boo;
}

sub markRegex {
    my $output = shift;
    my $regex = shift;
    my @outline = split /\n/, $output;
    $regex =~ s/(\.\*)/${1}?/g;
    print "=== doing markRegex for keyword: $regex\n"; #####
    foreach my $line (@outlines) {
        ## does not being with whitespace (where email headers & footers go), is not html but can have the bold HTML tag, 
	## and has the case-insensitive regex
	if ($line !~ /^\s+/ && ($line !~ /\<.*\>/ || $line =~ /\<b\>.*\<\/b>/) && $line =~ /${regex}/i)  {
	    print "marking line\n$line\n"; ######
	    $line =~ s/(\n|({regex})(\b)/${1} <b>${2}<\/b> ${3}/ig;
	    ##$line =! s/__(\s+)(.*)(\s+)__/__$(2)__/;
	}
	$output2 .= $line . "\n";
    }
    $output2;
}
    
