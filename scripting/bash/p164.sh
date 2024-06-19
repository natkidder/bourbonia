## illustrates clobbering
tput clear
set -o | grep noclobber
echo 'set -o noclobber'
set -o noclobber
set -o | grep noclobber
echo 'rm p164_1.txt'
rm p164_1.txt
echo 'touch p164_1.txt'
touch p164_1.txt
#echo answer \'n\' to the following
echo 'echo '\''override'\'' > p164_1.txt'
echo 'override' > p164_1.txt
echo 'cat p164_1.txt'
cat p164_1.txt
echo 'echo '\''override'\'' >| p164_1.txt'
echo 'override' >| p164_1.txt
echo 'cat p164_1.txt'
cat p164_1.txt
