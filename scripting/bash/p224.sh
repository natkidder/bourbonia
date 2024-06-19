## illustrates noexec
echo before noexec
set -o noexec
echo into noexec
PS3='Select File: '
SelectFile ()
{
  select selection in $(ls p2*.unx)
  doihuoiu
    if [ $selection ]; then
      echo You selected $REPLY; read
      ./$selection
      break -q
    else
      echo 'wrong, try again'
    fi
  done
}
SelectFile
set +o noexec
