#!/usr/bin/perl -w

use strict;

my $cmd = 'java ' .
    '-Djavax.net.ssl.trustStore=/home/kalin/glassfish-v2ur2/domains/domain1/config/keystore.jks ' .
    '-Djavax.net.ssl.trustStorePassword=changeit ' . 
    '-Djavax.net.ssl.keyStore=/home/kalin/glassfish-v2ur2/domains/domain1/config/cacerts.jks ' .
    '-Djavax.net.ssl.keyStorePassword=changeit ' .
    'EchoSSLClient';

print $cmd, "\n";
system($cmd);
