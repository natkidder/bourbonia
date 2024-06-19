#!/bin/perl -w
# bp 258

use strict;

print "\n";
print 'use Net::FTP;' . "\n";
print "\n";
print 'my $ftp= Net::FTP->new("ftp.cpan.org")   or   die "Couldn\'t connect: $@\n";' . "\n";
print "\n";
print '$ftp->login("anonymous");' . "\n";
print '$ftp->cwd("/pub/CPAN");' . "\n";
print '$ftp->get("README.html");' . "\n";
print '$ftp->close();' . "\n";
print "\n"; 


use Net::FTP;

my $ftp= Net::FTP->new("ftp.cpan.org")
   or die "Couldn't connect: $@\n";

$ftp->login("anonymous");
$ftp->cwd("/pub/CPAN");
$ftp->get("README.html");
$ftp->close();
