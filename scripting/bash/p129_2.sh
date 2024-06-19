# illustrates use of case
for filename in $(find . -mtime -9999 -print)
do
  if [ -d $filename ]; then
    echo $filename is a directory
  else
    ext=${filename##*.}
    case $ext in 
      mdb | xls | doc ) echo $filename is an Office file ;;
      txt ) echo $filename flat text data file ;;
      exe ) echo $filename is a compiled executable ;;
      unx ) echo $filename is a bash executable ;;
      * ) echo $filename none of the above ;;
    esac
  fi
done
