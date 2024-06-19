## illustrates RETURN trap
if test ${0##*/} = p229_1.unx; then
  echo source ${0##*/}
  exit 2
fi
echo
trap "echo 'script p229_1.unx finished'" RETURN
~/.bashrc
source ~/.functions
cat p229-11.unx
source p229-11.unx
wait
