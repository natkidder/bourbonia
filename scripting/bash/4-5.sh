echo $# "$@" #####
if [ -z "$1" ]; then
  echo "arg1: field number"
  exit 1
elif [ -z "$2" ]; then
  echo "arg2: file to examine"
  exit 1
fi
cut -f$1 -d\| $2
