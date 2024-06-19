# illustrates the test builtin
if test -d /cygdrive/d; then
  echo 'DVD drive has a CD-ROM medium'
else
  echo 'DVD drive has no CD-ROM medium'
fi

if test 1 -eq 2; then
  echo '1 equals 2'
else
  echo '1 does not equal 2'
fi

if test -z "$1"; then
  echo no arguments passed
fi
