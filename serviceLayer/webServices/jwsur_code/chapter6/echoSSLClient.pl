#!/usr/bin/perl -w
use strict;

my $cmd = 'java -Djavax.net.ssl.trustStore=cacerts.jks ' .
    '-Djavax.net.ssl.trustStorePassword=changeit ' .
    '-Djavax.net.ssl.keyStore=keystore.jks ' .
    '-Djavax.net.ssl.keyStorePassword=changeit EchoSSLClient';

system($cmd);
print "\n";
