## DEBUG trap inheritance
#tput clear
echo -e '\n' 'set -o functrace'
set -o functrace
set -o | grep functrace
echo
echo 'trap '\''echo $LINENO: pos is $pos, pos2 is $pos2'\'' DEBUG '
trap 'echo $LINENO: pos is $pos, pos2 is $pos2' DEBUG 
pos='outside of aFunct'
aFunct ()
{
  pos2='inside of aFunct'
}
aFunct
trap - DEBUG
echo -e '\n' 'set +o functrace'
set +o functrace
set -o | grep functrace
echo -e '\n' 'set -T'
set -T
set -o | grep functrace
set +o functrace
echo
