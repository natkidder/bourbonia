# fun with CDPATH
source ~/.bashrc
cls
echo 'export CDPATH='\''/cygdrive/c/MyDocs:/cygdrive/c/MyDocs/career'\'
export CDPATH='/cygdrive/c/MyDocs:/cygdrive/c/MyDocs/career'
echo CDPATH=$CDPATH
declare -f cd
echo 'cd $HOME'
cd $HOME
#pwd
echo 'cd Resume'
cd Resume
#pwd
echo 'cd home/Emily'
cd home/Emily
#pwd
