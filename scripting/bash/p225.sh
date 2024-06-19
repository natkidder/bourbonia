## illustrates the EXIT fake signal
tput clear
echo -e '\n' 'trap '\''echo Waking up from sleep, your lucky number is $RANDOM'\'' EXIT'
trap 'echo Waking up from sleep, your lucky number is $RANDOM' INT EXIT
echo -e '\n' 'sleep 5'
sleep 9
echo
