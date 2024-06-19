## LTBS, p 120
if [ ${0##*/} = RecursionExample.unx ]; then
  echo source ${0##*/} 
  exit 2
fi
cd()
{
## ensure the 'builtin' is placed before 'cd' below--otherwise you get infinite
## recursion
  builtin cd "$@"
## OLDPWD is your former directory
  echo "$OLDPWD-> $PWD" " returned status $?"
}
