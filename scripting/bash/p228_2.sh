## DEBUG trap inheritance
#tput clear
set -o | grep functrace
echo -e '\n' 'trap '\''echo $LINENO: pos is $pos, pos2 is $pos2, pos3 is $pos3'\'' DEBUG '
trap 'echo $LINENO: pos is $pos, pos2 is $pos2, pos3 is $pos3' DEBUG 
pos='outside of aFunct'
aFunct ()
{
  pos2='inside of aFunct'
  local pos3='locally inside of aFunct'
}
aFunct
echo -e '\n' 'trap - DEBUG'
trap - DEBUG
echo
