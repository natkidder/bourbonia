## illustrates wait
echo 'ensure you have deleted p215-1.txt first'
echo -e '\n' 'sleep 20 &; ls -l > p215-1.txt; wait'
sleep 20 &
ls -l > p215-1.txt
wait
