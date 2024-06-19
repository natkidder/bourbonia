#!/bin/perl
# bp 19

print "\n";

print 'qq|\'"Hi," said Jack. "Have you read /. today?"\'\n|;'."\n";
print qq|'"Hi," said Jack. "Have you read /. today?"'\n\n|;

print 'qq#\'"Hi," said Jack. "Have you read /. today?"\'\n#;'."\n";
print qq#'"Hi," said Jack. "Have you read /. today?"'\n\n#;

print "Note: ( must be closed with ), and < must be closed with >\n\n";

print 'qq(\'"Hi," said Jack. "Have you read /. today?"\'\n);'."\n";
print qq('"Hi," said Jack. "Have you read /. today?"'\n\n);

print 'qq<\'"Hi," said Jack. "Have you read /. today?"\'\n>;'."\n";
print qq<'"Hi," said Jack. "Have you read /. today?"'\n\n>;
