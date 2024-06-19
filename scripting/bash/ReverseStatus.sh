# see if argument was passed
if test -z "$1" 
then
  echo "arg1: command to test"
  exit 1
elif [ -n "$2" ]
then
  echo "enclose arg1 in single quotes ('')"
  exit 1
fi

## ! <command> returns the reverse of the status of that command
if ! $1
then
  echo "'$1' failed"
#  exit 1
fi
