package Person7;
# bp 277

# Class for storing data about a person

use strict;

my @Everyone;  ## class attribute

sub new {
  my $class = shift;  ## 1st arg is module called (Person7 in this case)
  my $self = {@_};    ## anonymous hash holding the ('d args to new
  bless $self, $class;
  $self->_init();
  return $self;
}

sub _init {         ## a private method
  my $self = shift;   ## the ref that called _init() in the first place
  push @Everyone, $self;
}

# Object accessor methods

sub address   { 
  if (defined $_[1]) { 
    $_[0]->{address  } = $_[1] ;
  }
  $_[0]->{address  } ;
}
sub lastname  { 
  if (defined $_[1]) { 
    print "lastname \$_: " . $_;
    $_[0]->{lastname } = $_[1] ;
  }
  $_[0]->{lastname } ;
}
sub firstname { $_[0]->{firstname} = $_[1] if defined $_[1]; $_[0]->{firstname} }
sub phone_no  { $_[0]->{phone_no } = $_[1] if defined $_[1]; $_[0]->{phone_no } }
sub occupation {
  $_[0]->{occupation} = $_[1] if defined $_[1]; $_[0]->{occupation}
}

# Class accessor methods

sub headcount { return scalar @Everyone };
sub everyone  { return @Everyone        };

sub CriticalCodeLines {
  print "Person7.pm:\n";
  print 'my @Everyone;  ## class attribute, need not be just a scalar' . "\n";
  print 'sub new {' . "\n";
  print '  ...' . "\n";
  print '  $self->_init(); # add the object to the array of objects;' . "\n";
  print '  ...' . "\n";
  print '}' . "\n";
  print 'sub _init {         ## a private method' . "\n";
  print '  my $self = shift;' . "\n";
  print '  push @Everyone, $self;' . "\n";
  print '}' . "\n";
  print 'sub headcount { return scalar @Everyone };' . "\n";
  print 'sub everyone  { return @Everyone        };' . "\n";
}

1;
