## illustrates the DEBUG trap
PS3='Select File: ' 
SelectFile () 
{ 
select selection in $(ls p2*.unx)
  do
    if [ $selection ]; then
      echo You selected $REPLY; read
trap 'echo the file you will run is $selection; read' DEBUG 
      ./$selection
trap - DEBUG
      break
    else
      echo 'wrong, try again'
    fi
  done
}
SelectFile
