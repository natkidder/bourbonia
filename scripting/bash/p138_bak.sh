# illustrates shift 
lsf () 
{
  arg=$1
  while [ ${arg:0:1} = '-' ] #[ -n "echo $1 | grep '-'" ] && [ -n "$1" ]
  do
    echo '$1='$1 ####
    case $1 in 
    -d )
      for filename in $(ls)
      do
        if [ -d $filename ]; then
          echo $filename is a directory
        fi
      done
      shift ;;
    -f )
      for filename in $(ls)
      do
        if [ -f $filename ]; then
          echo $filename is a regular file
        fi
      done
      shift ;;
    * )
      echo 'usage: lsf [-d] [-f]' 
      exit 5 
    esac
  if [ -z "$1" ]; then
    arg='_'
  else
    arg=$1
  fi
  done
}
lsf -d 
echo '==========================================='
read
lsf -f 
echo '==========================================='
read
lsf -d -f
echo '==========================================='
read
lsf -f -d
