## ERR trap inheritance by a called file
trap "echo 'error in $0, line $LINENO was # $?'" ERR
cat p226-21.unx
./p226-21.unx
