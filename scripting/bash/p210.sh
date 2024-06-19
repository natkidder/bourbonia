## shell variable related to processes
echo -e '\n' 'ps '
ps 
echo -e '\n' 'echo $$'
echo $$
echo -e '\n' 'sleep 10 &'
sleep 10 &
echo -e '\n' 'ps '
ps 
#read -p 'Wait a few seconds, then press Enter' reply
echo -e '\n' 'echo $!'
echo $!
