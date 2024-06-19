## illustrates jobs and processes
#tput clear
#echo 'grep nrkidder $(find c:/mydocs/career/training -name '\''*.txt'\'' -print) > p198_1.txt 2>&1 &'
#grep nrkidder $(find c:/mydocs/career/training -name '*.txt' -print) > p198_1.txt &
echo -e '\n' 'sleep 20 &'
sleep 20 &
echo 'grep nrkidder $(find c:/mydocs -name '\''*.unx'\'' -print) > p198_1.txt 2>&1 &'
grep nrkidder $(find c:/mydocs -name '*.unx' -print) > p198_1.txt &
echo -e '\n' 'jobs -x echo %+'
jobs -x echo %+
echo -e '\n' 'jobs'
jobs
echo -e '\n' 'jobs -l'
jobs -l
echo -e '\n' 'jobs -p'
jobs -p
echo -e '\n' 'ps -a'
ps -a 
echo -e '\n' the arguments to \'jobs -x echo\' are also suitable for \'fg\'
echo -e '\n' 'jobs -x echo %sleep'
jobs -x echo %sleep
echo -e '\n' 'jobs -x echo %1'
jobs -x echo %1
echo -e '\n' 'jobs -x echo %+'
jobs -x echo %+
echo -e '\n' 'jobs -x echo %?20'
jobs -x echo %?20
echo
