## illustrates disown
tput clear
echo -e '\n' 'sleep 10 &'
sleep 10 &
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps'
ps
echo -e '\n' 'disown $(ps | grep sleep | cut -c5-11)'
disown $(ps | grep sleep | cut -c5-11)
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps'
ps
echo 'wait 10 seconds...'
sleep 10
tput clear
echo -e '\n' 'sleep 10 &'
sleep 10 &
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps'
ps
echo -e '\n' 'disown -r'
disown -r
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps'
ps
echo 'wait 10 seconds...'
sleep 10
tput clear
echo -e '\n' 'sleep 10 &'
sleep 10 &
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps'
ps
echo -e '\n' 'disown -r'
disown -a
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'ps'
ps
