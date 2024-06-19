package Wibble;
# bp 290

use strict;

use Exporter;
our @ISA = qw(Exporter);
our @EXPORT_OK = qw(wobble bounce boing);
our @EXPORT    = qw(bounce);

sub wobble { print "wobble\n" }
sub bounce { warn  "bounce\n" }
sub boing  { die   "boing!\n" }

1;
