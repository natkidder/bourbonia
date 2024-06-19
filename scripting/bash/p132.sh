# illustrates use of SELECT
source ~/.bashrc
cls
IFS=:
SelectDir ()
{
  PS3='Select Directory: '
  select selection in $PATH
  do
    if [ $selection ]; then
      echo You selected $REPLY; read
      lf $selection
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectDir
