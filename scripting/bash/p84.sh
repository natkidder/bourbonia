# precedence of command sources
source ~/.functions
echo -e '\n' ' source ./p84-1.unx'
source ./p84-1.unx # source the function
read -p '  press Enter'
cls
echo 'type -a ls'
type -a ls
echo 'alias ls='\''echo alias of ls'\'
alias ls='echo alias of ls'
echo -e '\n' ' type -a ls'
type -a ls
echo -e '\n' ' ls'
ls
echo -e '\n' ' unalias ls'
unalias ls
echo -e '\n' ' type -a ls'
type -a ls
echo -e '\n' ' ls *.txt'
ls *.txt
