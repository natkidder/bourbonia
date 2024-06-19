# demonstrates called scripts and functions that openly return a value
# called script

if [ -e "$1" ]; then
  exit 0
else 
  exit 1
fi
