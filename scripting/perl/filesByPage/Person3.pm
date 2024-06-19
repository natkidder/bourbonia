package Person3;
# bp 270

use strict;

sub showNew {
  print "\n";
  print 'sub new {' . "\n";
  print '  my $class = shift;' . "\n";
  print '  my $self = {@_};' . "\n";
  print '  bless $self, $class;' . "\n";
  print '  return $self;' . "\n";
  print '}' . "\n";
  print "\n";
}

sub new {
  my $class = shift;
  my $self = {@_};
  bless $self, $class;
  return $self;
}

1;
