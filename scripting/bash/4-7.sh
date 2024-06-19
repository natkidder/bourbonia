#to get this function used in the shell, use source <filename>
echo $0 ${0##*/} 
if [ ${0##*/} = 4-7.unx ]; then
  echo source $0 
  exit 2
fi
function lsd
{
  date=$1
  DateCol=40
  let FileCol=DateCol+14
#  ls -l | grep -i "^.\{${DateCol}\}$date" | cut -c${FileCol}-
  ls -l | grep -i "^.\{40\}$date" | cut -c48-
}
