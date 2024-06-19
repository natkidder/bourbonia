
## Simple expat-based XML non-validating parser invoked through a 
## Perl script. The script requires the name of the
## XML file as a command-line argument. No news is good news.

use strict;                                            ## variables must be declared
use XML::Parser;                                       ## use a package

die "Invoke as: parse.pl <XML file>" unless $ARGV[0];  ## ensure proper invocation

my $expat = new XML::Parser();                         ## construct the parser 
$expat->parsefile($ARGV[0]);                           ## parse the XML document
