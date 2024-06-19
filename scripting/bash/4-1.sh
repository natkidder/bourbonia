#
#  highest filename [howmany]
# 
#  Print how many highest-numbered line in the file filname
#  The input file is assumed to have lines that start with
#  numbers.  Default for howmany is 10
#

#filename=${1}
#filename=${1:-filename missing}
filename=${1:?filename missing}
howmany=${2}
header=$3

#check for required filename parameter's existence
if [ -z "$filename" ]; then
  echo '$1: File Name'
  exit 0
fi

echo -n -e ${header:+"Nbr   Title\n\n"}
# set howmany's default here because you can't do it with positional params
sort -nr $filename | head -${howmany:=10}
