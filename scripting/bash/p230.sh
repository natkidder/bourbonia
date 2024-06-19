## illustrates 4 environment variables related to debugging
## example usage: p230.unx 'ls' 'p2*.unx'
#tput clear
if [ -z "$1" ] || [ -z "$2" ]; then
  echo "usage: command files"
  exit
fi
echo BASH_SOURCE=$BASH_SOURCE
echo BASH_LINENO=$BASH_LINENO
echo BASH_ARGC=$BASH_ARGC
echo BASH_ARGV=$BASH_ARGV
echo
if command $1 >2 || builtin $1 >2; then
  exec $1 $2
fi
