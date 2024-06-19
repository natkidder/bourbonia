## illustrates file descriptors
tput clear

## run this file with the given parameters, and it runs in the background with
## std error & output is in the log file 
## from the book
funct72 ()
{
  "$@" > logfile 2>&1 &
}
funct72 a b c

a 2>&1 > logfile2

## our own example of sending both std error to the same place as std output
## (std output goes to logfile72, as given by the 1st '>'
## Also, job runs in the background
echo ' chmod 000 7-2dir'
chmod 000 7-2dir
echo ' du . > logfile72 2>&1 &'
du . > logfile72 2>&1 &
echo ' cat logfile72'
cat logfile72
echo
read -p '--press enter--'

## sending both std error & std output to something else
echo ' ls *d* 2>&1 | tail -5'
ls *d* 2>&1 | tail -5
read -p '--press enter--'

## equivalent syntax
echo 'ls *.txt >&1'
ls *.txt >&1
echo ' cat <&0'
cat <&0
read -p '--press enter--'

## inputing from standard input
echo 'cat <&0 > 7-2_1.txt'
echo 'enter a string:'
cat <&0 > 7-2_1.txt
echo ' cat 7-2_1.txt'
cat 7-2_1.txt
read -p '--press enter--'

## plain old redirecting standard error
rm 7-2_2.txt
echo '-- from 7-2_2.unx --' 1>> 7-2_2.txt
echo 'ls -l p23* 2>> 7-2_2.txt'
ls -l p23* 2>> 7-2_2.txt
echo 'find . -name '\''*.dll'\'' -print 2>> 7-2_2.txt'
find . -name '*.dll' -print 2>> 7-2_2.txt
echo ' cat 7-2_2.txt'
cat 7-2_2.txt

## reset permissions
chmod 777 7-2dir
