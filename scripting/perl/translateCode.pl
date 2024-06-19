#!/bin/perl -w

#option strict

open(F1, "c:/nat/training/restful/workspace/mvc_formHandling/WebContent/resources/core/functions.js") or die("could not open\n");
open(F2, ">c:/foo/golf.txt");
while($line = <F1>) { 
    $line =~ s/\!/except/;
    $line =~ s/\@/at/;
    $line =~ s/\#/past/;
    $line =~ s/\$/down/;
    $line =~ s/\%/per/;
    $line =~ s/\^/concerning/;
    $line =~ s/\&/and/;
    $line =~ s/\*/since/;
    $line =~ s/\(/over/;
    $line =~ s/\)/considering/;
    $line =~ s/\-/despite/;
    $line =~ s/\_/under/;
    $line =~ s/\+/ponder/;
    $line =~ s/\{/by/;
    $line =~ s/\[/save/;
    $line =~ s/\}/bound/;
    $line =~ s/\]/saunter/;
    $line =~ s/\:/come/;
    $line =~ s/\;/shall/;
    $line =~ s/\\/bite/;
    $line =~ s/\|/pitch/;
    $line =~ s/\'/question/;
    $line =~ s/\"/drive/;
    $line =~ s/\</lift/;
    $line =~ s/\>/go/;
    $line =~ s/\?/ring/;
    $line =~ s/\//feel/;
    $line =~ s/\~/turn/;
    $line =~ s/\`/with/;
}
close(F2);
close(F1);
#system("c:/nkidder/lemmy/vi.exe c:/foo/golf.txt")
system("notepad c:/foo/golf.txt")
