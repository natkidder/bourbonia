#illustrates arithmetic for loops
for ((i=1; i < 10 ; i++))
do
  echo $i:
  ls p${i}*.unx
  read
done
