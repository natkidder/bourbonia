#!/usr/bin/perl -w

use strict;

my $cmd = 'java ' .
    '-cp .:/home/kalin/tomcat6/lib/catalina.jar:/home/kalin/tomcat6/bin/tomcat-juli.jar ' .
    '-Djavax.net.ssl.trustStore=/home/kalin/.keystore ' .
    '-Djavax.net.ssl.trustStorePassword=changeit ' . 
    '-Djavax.net.ssl.keyStore=/home/kalin/.keystore ' .
    '-Djavax.net.ssl.keyStorePassword=changeit ' .
    'DispatchClientTC';

print $cmd, "\n";
system($cmd);
