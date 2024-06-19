## illustrates reading a file line-by-line
find . -mtime -999 -print > p173-1.txt
{
  declare -i i=0
  declare -i j=0
  while read filename
  do
    if [ -d  $filename ]; then
      echo $filename is a directory
    elif [ -x $filename ]; then
      echo $filename is an executable file
    elif [ -r $filename ]; then
      echo $filename is readable at least
    else
      echo $filename appears to be of little use
    fi

    j=$(($((i++))%10)) ####

    if [ $j -eq 0 ]; then
      read 
      echo ---------------------------
    fi

  done
} < p173-1.txt

read

IFS=' '
ls -l p2*.unx> p173-2.txt 
while read -a LsLine; do
  echo ${LsLine[0]} ${LsLine[6]} ${LsLine[7]} ${LsLine[9]}
done < p173-2.txt
