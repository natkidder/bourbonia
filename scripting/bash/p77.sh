# fun with terminal types
source ~/.bashrc
cls
echo 'cd /usr/lib/terminfo'
cd /usr/lib/terminfo
echo 'find . -name $TERM -print'
find . -name $TERM -print
echo 
echo 'echo $EDITOR'
echo -e $EDITOR '\n'
echo 'echo $SHELL'
echo -e $SHELL '\n'
echo 'echo $BASH'
echo -e $BASH '\n'
echo 'cd -'
cd -
