# illustrates fc
if [ ${0##*/} = p45.unx ]; then
  echo "source ${0##*/} for it to work"
  exit 2
fi
echo -e '\n' 'export FCEDIT=vim'
export FCEDIT=vim
echo -e '\n' 'du'
du
echo -e '\n' 'df -a'
df -a
echo -e '\n' 'fc du'
fc du
echo -e '\n' 'fc -l '
fc -l 
echo -e '\n' 'fc -s df -a'
fc -s df -a
