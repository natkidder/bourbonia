#!/bin/perl -w

use strict;
use File::Copy;

copy("/cygdrive/c/inetpub/wwwroot/publications/XSL/ER_TABLEC.xsl","//edfswn07p/ifs/xsl/ER_TABLEC.xsl");
copy("/cygdrive/c/inetpub/wwwroot/publications/XSL/ER_TABLEC.xsl","//edfswn07p/ifs/xsl_newfont/ER_TABLEC.xsl");

print "run from ENV(perlfiles)\n";
