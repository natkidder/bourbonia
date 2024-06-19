#!/bin/perl -w
# bp 304

use strict;
use Win32::Sound;

Win32::Sound::Volume(65535);
while (<*.wav>) {
  Win32::Sound::Play($_);
}
