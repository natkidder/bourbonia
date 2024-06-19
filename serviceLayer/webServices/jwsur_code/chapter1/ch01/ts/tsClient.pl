#!/usr/bin/perl -w

use SOAP::Lite;
##use SOAP::lib::SOAP::Lite;
my $url = 'http://127.0.0.1:9876/ts?wsdl';
my $service = SOAP::Lite->service($url);

print "\nCurrent time is: ", 
    $service->getTimeAsString();
print "\nElapsed milliseconds from the epoch: ", 
    $service->getTimeAsElapsed(), "\n";

sub BEGIN {
  unshift @INC, "/usr/lib/perl5/5.10/SOAP/lib"
}
