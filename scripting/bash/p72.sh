# runs 'hash' in a subshell
if [ $0 = ./p72.unx -o ${0##*/} = p72.unx ]; then
  echo "source $0 to get meaningful information"
  exit 2
fi
echo 'hash'
hash
