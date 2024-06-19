## illustrates xtrace
#tput clear
echo -e '\n' 'alias ll='\''ls -l'\'
alias ll='ls -l'
echo -e '\n' 'PS4="$0, line $LINENO: "'
PS4="$0: line $LINENO: "
echo -e '  will run:\n' '  ll $train/p75*.unx | cut -c$((40+4))-'
echo -e '\n' 'set -o xtrace'
set -o xtrace
ll $train/p75*.unx | cut -c$((40+4))-
#echo -e '\n' 'set +o xtrace'
set +o xtrace
echo
