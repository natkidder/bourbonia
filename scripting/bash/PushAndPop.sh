# to activate, type source <filename>
# cd has to be preceded by 'builtin' because there's a function 'cd' used to 
# illustrate recursion
# 1st if from LTBS, p 118
if [ ${0##*/} = PushAndPop.unx ]; then
  echo source $0
  exit 2
fi

pushd ()
{
  dirname=$1
## if dirname exists and isn't null, rtn its value, otherwise return after -
###  if builtin cd ${dirname:?"missing directory name."}
  if [ -n "$dirname" ] && [ \( -d "$dirname" \) -a \( -x "$dirname" \) ]
###  if [ \( -n "$dirname" \) -a \( -d "$dirname" \) -a \( -x "$dirname" \) ]
  then
    DIR_STACK="$dirname|${DIR_STACK:-$(builtin cd -)|}"
    cd $dirname
    echo $DIR_STACK
  else
    echo "Still in $PWD"
  fi
}

popd ()
{
#  local NewDir
  if [ -n "$DIR_STACK" ]; then  
    DIR_STACK=${DIR_STACK#*\|}
    builtin cd "${DIR_STACK%%\|*}"
    echo "$PWD"
  else
    echo "stack empty, still in $PWD"
  fi
}
