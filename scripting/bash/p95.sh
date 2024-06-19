# pattern matching
source ~/.bashrc
cls
echo PWD=$PWD
echo
echo '${PWD#*/}='${PWD#*/}
echo '${PWD##*/}='${PWD##*/}
echo
echo '${PWD%/*}='${PWD%/*}
echo '${PWD%%/*}='${PWD%%/*}
echo
echo '${PWD/\/cygdrive\/c/c:}='${PWD/\/cygdrive\/c/c:}'=PWD_COLON'
PWD_COLON=${PWD/\/cygdrive\/c/c:}
echo '${PWD_COLON//\//\\}='${PWD_COLON//\//\\}
echo
