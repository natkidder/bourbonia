#! /bin/perl -w

$TestStr = $ARGV[0];
$MatchStr = $ARGV[1];

if ($TestStr =~ m/"$MatchStr"/i)
{
  print $TestStr . " matches m/" . $MatchStr . "/i\n";
}
else
{
  print $TestStr . " does not match m/" . $MatchStr . "/i\n";
}
