source ~/.bashrc
cls
SelectDir ()
{
  PS3='Select File: '
  select selection in $(ls select*.unx)
  do
    if [ -e $selection ]; then
#      echo You selected $REPLY: $selection; read
      ./$selection
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectDir
