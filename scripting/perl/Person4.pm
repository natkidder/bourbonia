package Person4;
# bp 271

# Class for storing data about a person

use strict;

sub showClassCode {
  print 'sub new {' . "\n";
  print '  my $class = shift;  ## ASSUMES the class name is the 1st arg' . "\n";
  print '  my $self = {@_};    ## object takes in all the other args' . "\n";
  print '  bless $self, $class;' . "\n";
  print '  return $self;' . "\n";
  print '}' . "\n";
  print 'sub lastname {' . "\n";
  print '  my $self = shift;  ## ASSUMES arg is a hash reference' . "\n";
  print '  return $self->{lastname};' . "\n";
  print '}' . "\n";
}

sub new {
  my $class = shift;  ## ASSUMES the class name is the 1st arg
  my $self = {@_};    ## object takes in all the other args
  bless $self, $class;
  return $self;
}

sub lastname {
  my $self = shift;  ## ASSUMES arg is a hash reference
  return $self->{lastname};
}

1;
