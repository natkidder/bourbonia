# illustrates command substitution
source ~/.bashrc
cls
echo -e '\n' 'sort < $(ls p1*.unx)'
sort < $(ls p1*.unx)
echo
read -p 'press enter'
echo -e '\n' 'cat < $(ps -a)'
cat < $(ps -a)
read -p 'word.unx `command ls *.doc`'
word.unx `command ls *.doc`
echo
