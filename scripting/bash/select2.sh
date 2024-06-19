source ~/.bashrc
cls
SelectDir ()
{
  PS3='Select File: '
  select selection in $(ls p2[0-9][0-9]*.unx)
  do
    if [ -e $selection ]; then
      echo You selected $REPLY: $selection; read
      cat $selection
      echo
      read -p 'press Enter to continue'
      echo
      ./$selection; wait
      echo -- $selection --
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectDir
