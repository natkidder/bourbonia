# run a file with high priority, using nice
# also illustrates file and integer checking (p 148)

declare -i Niceness=$1

#if [ ! -n "$2" ] || [ -d "$2" ] || [ ! -x "$2" ]; then ####RTF
if [ ! -e "$2" ]; then
  echo arg2: file must exist
  exit -5
elif [ -d "$2" ]; then
  echo arg2: non-directory
  exit -6
elif [ ! -x "$2" ]; then
  echo arg2: executable file
  exit -7
elif [ -z "$Niceness" ]; then
  echo arg1: niceness
  exit 6
#NOTE: this needs rework
#elif [ \( $Niceness -lt -20 \) || \( $Niceness -gt 19 \) ]; then
elif [ $Niceness -lt -20 ] || [ $Niceness -gt 0 ]; then
  echo arg1: niceness must be between -20 and 0
  exit 7
fi
echo passed error checking
nice $Niceness "$2"
