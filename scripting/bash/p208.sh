## simple use of trap
echo -e '\n' 'trap "echo You pressed ctrl-c" INT'
trap "echo You pressed ctrl-c" INT
echo press cntl-c now
echo -e '\n' 'sleep 1m'
sleep 1m
echo -e '\n' 'trap - INT'
trap - INT
