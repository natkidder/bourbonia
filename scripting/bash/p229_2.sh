## illustrates RETURN trap inheritance
if test ${0##*/} = p229_2.unx; then
  echo source ${0##*/}
  exit 2
fi
echo
trap "echo 'exiting p229_2.unx, FunctVar =' $FunctVar" RETURN
function aFunct 
{
  trap "echo 'exiting aFunct, FunctVar =' $FunctVar" RETURN
  FunctVar="Variable inside function"
  ls p*2.unx
}
aFunct
echo
