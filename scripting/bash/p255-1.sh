rm -f p255-1.txt
echo -e '\n' "umask $1"
umask $1
echo -e '\t' 'touch p255-1.txt'
touch p255-1.txt
ls -l p255-1.txt
