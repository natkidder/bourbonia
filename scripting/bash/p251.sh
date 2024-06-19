## illustrates symbolic links
echo -e '\n' 'rm p251-1.unx p251-2.unx'
rm p251-1.unx p251-2.unx
echo -e '\n' 'echo '\''ls -CF p2*.unx'\'' > p251-1.unx'
echo 'ls -CF p2*.unx' > p251-1.unx
echo -e '\n' 'chmod 777 p251.unx'
chmod 777 p251.unx
echo -e '\n' 'ln -s p251-1.unx p251-2.unx'
ln -s p251-1.unx p251-2.unx
echo -e '\n' 'chmod 777 p251-2.unx'
chmod 777 p251-2.unx
echo -e '\n' './p251-2.unx'
./p251-2.unx
echo
