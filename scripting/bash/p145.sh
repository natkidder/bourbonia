## illustrates declare
source ~/.bashrc
cls
## arrays
declare -a TestArray
TestArray=(a b c d e f g)
echo 'TestArray=(a b c d e f g)'
echo '{TestArray[0]}='${TestArray[0]}
echo '${#TestArray}='${#TestArray}
echo '{TestArray[${#TestArray}]}='${TestArray[${#TestArray}]}
echo '{TestArray[6]}='${TestArray[6]}
read
## functions
echo 'functions with definitions'
declare -f
read
echo 'function names only'
declare -F
## integers
echo integers; read
declare -i cnt
echo cnt, just declared without assignment: $cnt
echo cnt++: $((cnt++))
echo ++cnt: $((++cnt))
declare -i cnt2=${#PATH}
echo 'length of PATH (cnt2), plus 1 =' $((++cnt2))
echo '$((--cnt2))='$((--cnt2))
declare -i div1=7
declare -i quote1=$cnt2/$div1
echo length of PATH, divided by $div1: $quote1
read 
## read-only variable
echo read-only vars
echo declare -r ReadVar=ReadOnly
declare -r ReadVar=ReadOnly
echo 'ReadVar='$ReadVar
echo \'ReadVar=ActuallyWritable\' will generate an error
read
## exported variables
declare -x ExpVar=ExportedVariable
declare NonExpVar=NonExportedVariable
cat p145-1.unx
./p145-1.unx
