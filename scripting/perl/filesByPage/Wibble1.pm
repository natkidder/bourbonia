package Wibble1;
# bp 290

use strict;

use Exporter;
our @ISA = qw(Exporter);
our @EXPORT_OK = qw(wobble bounce boing);

sub wobble { print "wobble\n" }
sub bounce { warn  "bounce\n" }
sub boing  { die   "boing!\n" }

1
