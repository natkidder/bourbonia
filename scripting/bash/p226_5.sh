## ERR trap inheritance in command substitution
trap "echo 'error in $0, line $LINENO was # $?'" ERR
grep -i find "$(ls *.xxxxxx)"
