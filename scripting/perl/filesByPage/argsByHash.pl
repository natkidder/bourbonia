#!/bin/perl -w

##weather(sky => "sunny", temp => 70, humidity => 30);
weather(temp => 70, humidity => 30);
%weather = (sky => "sunny", temp => 70, humidity => 30);
while (($x,$y) = each(%weather)) {
  print "$x is $y\n";
}

sub weather {
  my %args = @_;
  if (!(exists $args{sky})) {
    $args{sky} = "partly cloudy";
  }
  while (($x,$y) = each(%args)) {
    print $x, " is ", $y, "\n";
  }
}
