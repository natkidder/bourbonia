package Person8;
# bp 279

# Class for storing data about a person

use strict;

my @Everyone;  ## class attribute

sub new {
  my $class = shift;  ## ASSUMES 1st arg is the class name
  my $self = {@_};  ## ASSUMES remaining args are class attributes
  bless $self, $class;
  $self->_init();
  return $self;
}

sub _init {         ## a private method
  my $self = shift;
  push @Everyone, $self;
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

# Utility methods

sub fullname {
  my $self = shift;
  return $self->firstname() . " " . $self->lastname();
}

sub printletter {
  my $self      = shift;
  my $name      = $self->fullname();
  my $address   = $self->address();
  my $firstname = $self->firstname();
  my $body      = shift;
  my @date      = (localtime)[3, 4, 5];
  $date[1]++;     ## months start at 0 so add 1 for display
  $date[2]+=1900; ## add 1900 (2000?) to get current year
  my $date      = join "/", @date;

  print <<EOF;

$name
$address

$date

Dear $firstname,

$body

Yours faithfully,
EOF
  return $self;
}

1;

sub CriticalCodeLines {
  print "Person8.pm:\n";
  print 'sub printletter {' . "\n";
  print '  my $self      = shift;' . "\n";
  print '  my $name      = $self->fullname();' . "\n";
  print '  my $address   = $self->address();' . "\n";
  print '  my $firstname = $self->firstname();' . "\n";
  print '  my $body      = shift;' . "\n";
  print '  my @date      = (localtime)[3, 4, 5];' . "\n";
  print '  $date[1]++;     ## months start at 0 so add 1 for display' . "\n";
  print '  $date[2]+=1900; ## add 1900 (2000?) to get current year' . "\n";
  print '  my $date      = join "/", @date;' . "\n";
  print '' . "\n";
  print '  print <<EOF;' . "\n";
  print '' . "\n";
  print '$name' . "\n";
  print '$address' . "\n";
  print '' . "\n";
  print '$date' . "\n";
  print '' . "\n";
  print 'Dear $firstname,' . "\n";
  print '' . "\n";
  print '$body' . "\n";
  print '' . "\n";
  print 'Yours faithfully,' . "\n";
  print 'EOF' . "\n";
  print '  return $self;' . "\n";
  print '}' . "\n";
}

1;
