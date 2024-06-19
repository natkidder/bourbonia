# illustrates command substitiution (LTBS, 100)
#
set -o xtrace
tput clear
echo -e "\n" 'll $(ls -a p11*.unx)'
read
ll $(ls -a p11*.unx)
echo -e "\n" 'echo $(ls $(pwd)/p11*.unx)'
read
echo $(ls $(pwd)/p11*.unx)
echo -e "\n" 'echo $(< 4-1.txt)'
read
echo $(< 4-1.txt)
echo -e "\n" 'ls -l $(type -p grep)'
read
ls -l $(type -p grep)
echo -e "\n" 'ls $(grep -l 'filename' *)'
read
ls $(grep -l 'filename' *)
echo
read -p 'xl.unx `command ls *.xls`'
xl.unx `command ls *.xls`
set +o xtrace
