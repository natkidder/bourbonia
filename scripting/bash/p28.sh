# history commands
if [ ${0##*/} = p28.unx ]; then
  echo 'source this file at the command prompt to find HISTFILE'
  exit 2
fi
source ~/.bashrc
#cls
ls -l p19*.unx
pwd
echo 'HISTFILE is :' $HISTFILE 
