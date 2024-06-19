source ~/.bashrc
cls
SelectDir ()
{
  PS3='Select File: '
  select selection in $(ls [A-Z]*.unx)
  do
    if [ -e $selection ]; then
      echo You selected $REPLY: $selection; read
      cat $selection
      echo
      read -p 'press Enter to continue'
      echo
      ./$selection
      echo -- $selection --
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectDir
