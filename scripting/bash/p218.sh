# what subshells do and don't inherit
tput clear
TopShellVar='top shell variable value'
echo -e '\n' in calling script, TopShellVar=$TopShellVar
env | sort > p218.txt
(echo -e '\n' in nested shell, TopShellVar=$TopShellVar)
./p218-1.unx
echo -e '\n' env diff between calling and called script
diff -w p218.txt p218-1.txt | more
(NestedShellVar='nested shell variable value')
echo -e '\n' In top shell, NestedShellVar=$NestedShellVar
(env | sort > p218-2.txt)
echo -e '\n' env diff between program and nested subshell
diff -w p218.txt p218-2.txt | more
