# illustrates use of case
cat p129.unx
read -p "Press <Enter> to Continue"
for filename in $(find . -mtime -9999 -print)
do
  if [ -d $filename ]; then
    echo $filename is a directory
  else
    ext=${filename##*.}
    case $ext in 
      doc ) echo $filename is a Word document ;;
      xls ) echo $filename is an Excel document ;;
      mdb ) echo $filename is an Access project/database ;;
      txt ) echo $filename flat text data file ;;
      exe ) echo $filename is a compiled executable ;;
      unx ) echo $filename is a bash executable ;;
      * ) echo $filename none of the above ;;
    esac
  fi
done
