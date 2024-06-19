## illustrates variations on ps
tput clear
echo -e '\n' 'ps'
ps
echo
echo -e '\n' 'ps -a'
ps -a
echo
echo -e '\n' 'ps -e'
ps -e
read -p 'press enter to continue' reply
#tput clear
echo -e '\n' 'ps -W'
ps -W | more
