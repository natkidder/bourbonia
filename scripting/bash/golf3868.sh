# fun with subprocesses
source ~/.bashrc
echo
echo 'export golf='\''/cygdrive/c/mydocs'\'
export golf='/cygdrive/c/mydocs'
echo ' ./p75-1.unx'
./p75-1.unx
echo 
echo 'golf2='\''/cygdrive/c/mydocs/career'\'
golf2='/cygdrive/c/mydocs/career'
echo 'echo $golf2'
echo $golf2
echo
echo ' ./p75-2.unx'
./p75-2.unx
echo
echo ' source ./p75-2.unx'
source ./p75-2.unx
echo -e "\n"
