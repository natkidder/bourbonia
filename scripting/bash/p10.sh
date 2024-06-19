#illustrates wildcard expansion
echo
echo -e '\n' ' ls [3-5]*.unx'
ls [3-5]*.unx
read -p 'press Enter'
echo
echo -e '\n' ' cat p10.txt'
cat p10.txt
read -p 'press Enter'
echo
echo explanation points do not work well as negators
echo -e '\n' ' grep [!a-zA-Z] p10.txt'
read -p 'press Enter'
grep [!a-zA-Z] p10.txt | more
sleep 5
echo
echo -e '\n' ' grep [0-9] p10.txt'
read -p 'press Enter'
grep  [0-9] p10.txt | more
echo
