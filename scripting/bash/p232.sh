## illustrates exec
#tput clear
echo -e '\n' 'try exec at the command line' '\n'
echo -e '\n' 'main file: exec sleep 10 &'
exec sleep 10 &
ps -a
echo -e '\n' 'main file: sleep 10'
sleep 10
ps -a
echo -e '\n' './p232-1.unx'
./p232-1.unx
echo -e '\n' 'returned to main file after ./p232-1.unx'
echo -e '\n' 'exec p232-1.unx'
exec p232-1.unx
echo -e '\n' 'returned to main file after exec p232-1.unx'
