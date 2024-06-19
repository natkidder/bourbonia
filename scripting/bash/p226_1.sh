## illustrate the ERR trap
ErrTrap ()
{
  es=$?
  echo "Error: process $0 exited with status $es at line $1"
}
##NOTE: LINENO must be literally specified outside the function where it's used
trap 'ErrTrap $LINENO' ERR
ls *.xxxx
