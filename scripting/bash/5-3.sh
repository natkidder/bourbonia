## creates a recursive directory listing
file=$1
echo $file
if [ -d $file ]; then
  cd $file
  ~/tracedir $(ls)
  cd ..
fi
