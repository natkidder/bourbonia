source ~/.bashrc
cls
SelectDir ()
{
  PS3='Select File: '
  select selection in $(ls p[1-2][0-9].unx)
  do
    if [ -e $selection ]; then
      echo You selected $REPLY: $selection; read
      cat $selection
      echo
      read -p 'press Enter to continue'
      echo
#      if [ $selection=p28.unx ]; then
        ./$selection; wait
#      else
#         set -o verbose
#        ./$selection; wait
#         set +o verbose
#      fi
      echo -- $selection --
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectDir
