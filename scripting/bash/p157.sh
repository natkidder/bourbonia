## illustrates arrays
IFS=:
declare -a PathArray
declare -i i=0
declare -i j=0
for dir in $PATH
do
  PathArray[$((i++))]=$dir
done
echo PATH=$PATH
read
for ((j=0 ; j<${#PathArray[@]} ; j++ ))
do
  echo 'PathArray['$j']='${PathArray[$j]}
done
