#!/bin/perl -w
# bp 293

use strict;

print "\n";
print 'use Acme::Webserver::Logger' . "\n";
print 'Acme::Webserver::Logger::open_log("webserver.log");' . "\n";
print "\n";


use Acme::Webserver::Logger;

##Acme::Webserver::Logger::open_log("webserver.log");
open_log("webserver.log");

# This will go to the log file
Acme::Webserver::Logger::write_log(1, "A basic message, level 1");

# This won't - the level is too high
Acme::Webserver::Logger::write_log(10, "A debugging message, level 10");

# Set the level so the debugging message will end up
# in the log file
Acme::Webserver::Logger::log_level(10);
Acme::Webserver::Logger::write_log(10, "Another debugging message, level 10");

Acme::Webserver::Logger::close_log();
