package Person2;  ## NOTE: no #!/bin/perl to open
# bp 268

# Class for storing data about a person

use strict;

sub showNew {
  print 'sub new {' . "\n";
  print '  my $self = {};' . "\n";
  print '  bless $self, "Person2";' . "\n";
  print '  return $self;' . "\n";
  print '}' . "\n";
}

sub new {
  my $self = {};
  bless $self, "Person2";
  return $self;
}

1;  ## always end a class/package with a 1 so it will return TRUE
