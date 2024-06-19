## ERR trap inheritance by nested subshell
trap "echo 'error in $0, line $LINENO was # $?'" ERR
(ls *.xxxxx)
