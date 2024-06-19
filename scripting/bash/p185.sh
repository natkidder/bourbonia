## illustrates command & builtin
tput clear
echo -e 'NOTE: in this file, cd and cp are local functions' '\n'
function cd
{
  echo $PWD
  builtin cd "$1"
  echo ' ' $PWD
}
echo 'cd $train/..'
cd $train/..
echo 'cd $train'
cd $train
function cp
{
  echo "copying $1 to $2 ..."
  command cp $1 $2
}
echo -e '\n' 'cp p75.unx golf$$.unx'
cp p75.unx golf$$.unx
ls -l p75.unx golf$$.unx
echo 'diff p75.unx golf$$.unx'
diff p75.unx golf$$.unx
echo

