echo -e '\n' 'p232-1.unx: sleep 10 &'
sleep 10 &
echo -e '\n' 'p232-1.unx: ps -a: focus on sh'
ps -a
echo -e '\n' 'p232-1.unx: should see return to main file'
