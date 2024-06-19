# illustrate for loop & directory permissions
for file in $(find . -mtime -9999 -print)  #$(ls -F)
do

  if [ -x $file ]; then
    if [ -d $file ]; then
      echo $file is searchable
    else
      echo $file is executable
    fi
  else
    echo $file is not much use now
  fi
done
