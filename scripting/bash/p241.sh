## illustrates break condition (bc)
echo 'NOTE: bc not supported in this cygwin implementation'

bc "grep 'p212' $filename"
bc "((i=5))"

declare int i=0
for filename in $(ls p21*.unx)
do
  echo $filename found
  ((i++))
done
