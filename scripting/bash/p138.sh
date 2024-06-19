# illustrates shift 
lsf () 
{
  arg=$1
  while [ ${arg:0:1} = '-' ] 
  do
    echo '$1='$1 ####
    case $1 in 
    -d )
      for filename in $(command ls -d $2)
      do
        if [ -d $filename ]; then
          echo $filename is a directory
        fi
      done
      shift;shift ;;
    -f )
      for filename in $(command ls $2)
      do
        if [ -f $filename ]; then
          echo $filename is a regular file
        fi
      done
      shift;shift ;;
    * )
      echo 'usage: lsf [-d] '\''filelist'\'' [-f]'\'filelist\' 
      exit 5 
    esac
  if [ -z "$1" ]; then
    arg='_'
  else
    arg=$1
  fi
  done
}
echo -e '\n' 'lsf -d '\''*'\'
lsf -d '*'
echo '==========================================='
read
echo -e '\n' 'lsf -f '\''p1[89]*.unx'\'
lsf -f 'p1[89]*.unx'
echo '==========================================='
read
echo -e '\n' 'lsf -d '\''*'\'' -f '\''*i*'\'
lsf -d '*' -f '*i*'
echo '==========================================='
read
echo -e '\n' 'lsf -f '\''p22*'\'' -d '\''*7*'\'
lsf -f 'p22*.unx' -d '*7*'
