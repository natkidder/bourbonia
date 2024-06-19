## ERR trap inheritance by a function in the same script
trap "echo 'error in $0, line $LINENO was # $?'" ERR
lsx ()
{ 
  ls *.xxxxx
}
lsx
