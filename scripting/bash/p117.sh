# check file attributes
source ~/.bashrc
cls
echo -e '\n' ' [ -e golf.txt ]'
if [ -e golf.txt ]; then
  echo "golf.txt exists"
fi
echo -e '\n' ' [ ! -d c:/mydocs ]'
if [ ! -d c:/mydocs ]; then
  echo 'can use <drive letter>: notation in testing directories'
echo -e '\n' ' elif [ -d /cygdrive/c/mydocs ]'
elif [ -d /cygdrive/c/mydocs ]; then
  echo 'should use '\''/cygdrive/<drive letter>'\'' notation instead'
fi
ls -l > golf.txt
echo -e '\n' ' [ -f golf.txt ]'
if [ -f golf.txt ]; then
  echo 'golf.txt is a regular file'
fi
chmod 333 golf.txt
echo -e '\n' ' [ -r golf.txt ]'
if [ -r golf.txt ]; then
  echo 'you have read permission on golf.txt'
else
  echo 'you do NOT have read permission on golf.txt'
fi
chmod 777 golf.txt
rm golf.txt
touch golf.txt
echo -e '\n' ' [ -e golf.txt ] && [ ! -s golf.txt ]'
if [ -e golf.txt ] && [ ! -s golf.txt ]; then
  echo golf.txt exists but is empty
fi
chmod 666 golf.txt
echo -e '\n' ' [ -w golf.txt ]'
if [ -w golf.txt ]; then
  echo You have write permission for golf.txt
else
  echo You do NOT have write permission for golf.txt
fi
chmod 666 golf.unx
echo 'ls -CF p*.unx' > golf.unx
chmod 555 golf.unx
echo -e '\n' ' [ -x golf.unx ]'
if [ -x golf.unx ]; then
  ./golf.unx
else
  echo You cannot execute golf.unx
fi
echo
read -p 'press enter'
echo -e '\n' ' [ -x /cygdrive/c/windows ]'
if [ -x /cygdrive/c/windows ]; then
  echo Go ahead, search through c:/windows
else
  echo c:/windows is closed to you
fi
chmod 666 golf.unx
echo '--done--' > golf.unx
echo -e '\n' ' [ -N golf.unx ]'
if [ -N golf.unx ]; then
  echo golf.unx was just modified
else
  echo golf.unx was run since last modified
fi
echo -e '\n' ' [ -O golf.unx ]'
if [ -O golf.unx ]; then
  echo you own golf.unx
else
  echo someone else owns golf.unx
fi
echo -e '\n' ' [ -G golf.unx ]'
if [ -G golf.unx ]; then
  echo golf.unx group matches yours
else
  echo you are NOT a member of golf.unx group
fi
echo -e '\n' ' [ ! -e golf2.unx ]'
if [ ! -e golf2.unx ]; then
  rm golf2.unx
fi
touch golf2.unx
echo -e '\n' ' [ golf.unx -nt golf2.unx ]'
if [ golf.unx -nt golf2.unx ]; then
  echo golf.unx is newer than golf2.unx
echo -e '\n' 'elif [ golf.unx -ot golf2.unx ]'
elif [ golf.unx -ot golf2.unx ]; then
  echo golf.unx is older than golf2.unx
fi
echo
