## illustrates sending a signal to a process
#tput clear
echo -e '\n' 'sleep 40 &'
sleep 40 &
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'jobs -x echo %sleep'
jobs -x echo %sleep
echo -e '\n' 'ps -a'
ps -a
#kill -KILL $(jobs -x echo %+)
echo -e '\n' 'kill -KILL $(ps | grep sleep | cut -c5-11)'
kill -KILL $(ps | grep sleep | cut -c5-11)
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps -a'
ps -a
echo -e '\n' 'jobs'
jobs
