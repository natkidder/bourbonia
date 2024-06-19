# this takes a .pcx file name and returns it as having the .jpg extension
# illustrates pattern-matching operators
#
filename=$1
if [ -z "$filename" ]; then
  echo -e "arg1: file name to convert\n"
  exit 1
elif [ "${filename##*.}" != "pcx" ]; then
  echo 'arg1: *.pcx file'
fi
echo "${filename##*.}" ####efp
echo from ${0##*/}: ${filename%.*}.jpg
cp $filename ${filename%.*}.jpg
