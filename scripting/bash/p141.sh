# illustrates getops
lsp ()
{
  while getopts "d:f:" switch; do
    case $switch in
      d ) echo 'd:OPTARG='$OPTARG #### 
           for filename in $(command ls $OPTARG); do 
           if [ -d $filename ]; then
               echo $filename is a directory
             fi
           done ;;
      f ) echo 'f:OPTARG='$OPTARG #### 
           for filename in $(command ls $OPTARG); do
             if [ -f $filename ]; then
               echo $filename is a regular file
             fi
           done ;;
      \? ) echo 'usage: lsp [-d dirs] [-f files]'
           exit 1
    esac
  done
  shift $(($OPTIND - 1))
}
echo WARNING:this needs work; read ####
lsp -d '*'
echo '==================================='
read
lsp -d '*' -f '*.doc'
echo '==================================='
read
lsp -f '*.*'
echo '==================================='
read
lsp -d '*'
echo '==================================='
read
