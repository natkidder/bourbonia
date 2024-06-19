#!/usr/bin/perl -w

use strict;

my $cmd = 'java ' .
    '-Djavax.net.ssl.trustStore=/home/kalin/.keystore ' .
    '-Djavax.net.ssl.trustStorePassword=changeit ' . 
    '-Djavax.net.ssl.keyStore=/home/kalin/.keystore ' .
    '-Djavax.net.ssl.keyStorePassword=changeit ' .
    'ClientAuth';

print $cmd, "\n";
system($cmd);
