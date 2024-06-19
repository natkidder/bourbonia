# positional parameters
source ~/.functions
cls
echo pass the following parameters: \'a b\' \'a#b\' \'a#@b\' \'a,b\'
echo IFS=$IFS
read -p 'IFS=,'
export IFS=,
echo -e '$* = ' $* '\t $@ = ' $@ '\t $# = ' $#
read -p 'IFS=#@'
export IFS=#@
echo -e '$* = ' $* '\t $@ = ' $@ '\t $# = ' $#
echo p87-funct.unx:
cat p87-funct.unx
echo
echo 'source ./p87-funct.unx'
source ./p87-funct.unx
p87-funct.unx 4
echo 'echo $LocalVar1'
echo $LocalVar1
echo 'LocalVars'
LocalVars
