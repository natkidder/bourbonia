package Person6;
# bp 274

# Class for storing data about a person

use strict;

my @Everyone;  ## class attribute

sub new {
  my $class = shift;  ## ASSUMES 1st arg is the class name
  my $self = {@_};  ## ASSUMES remaining args are class attributes
  bless $self, $class;
  push @Everyone, $self; # add the object to the array of objects;
  return $self;
}

# Object accessor methods

sub address   { $_[0]->{address  } = $_[1] if defined $_[1]; $_[0]->{address  } }
sub lastname  { $_[0]->{lastname } = $_[1] if defined $_[1]; $_[0]->{lastname } }
sub firstname { $_[0]->{firstname} = $_[1] if defined $_[1]; $_[0]->{firstname} }
sub phone_no  { $_[0]->{phone_no } = $_[1] if defined $_[1]; $_[0]->{phone_no } }
sub occupation {
  $_[0]->{occupation} = $_[1] if defined $_[1]; $_[0]->{occupation}
}

# Class accessor methods

sub headcount { return scalar @Everyone };
sub everyone  { return @Everyone        };

sub CriticalCodeLines {
  print "Person6.pm:\n";
  print 'my @Everyone;  ## class attribute, need not be just a scalar' . "\n";
  print 'sub new {' . "\n";
  print '  ...' . "\n";
  print '  push @Everyone, $self; # add the object to the array of objects;' . "\n";
  print '  ...' . "\n";
  print '}' . "\n";
  print 'sub headcount { return scalar @Everyone };' . "\n";
  print 'sub everyone  { return @Everyone        };' . "\n";
}

1;
