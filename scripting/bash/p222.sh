## illustrates verbose
set -o verbose
PS3='Select File: '
SelectFile ()
{
  select selection in $(ls p2*.unx)
  do
    if [ $selection ]; then
      echo You selected $REPLY; read
      ./$selection
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectFile
set +o verbose
