# demos extended patternmatching, 
#
tput clear
echo -e "\nshopt -s extglob"
shopt -s extglob
echo -e "\nls -a | wc"
ls -a | wc 
echo -e "\nls *(4-1.unx|4-2.unx|4-1.unx)"
ls *(4-1.unx|4-2.unx)
read -p 'press Enter'
echo -e "\nls +(4-1.unx|4-2.unx)"
ls +(4-1.unx|4-2.unx)
read -p 'press Enter'
echo -e "\nls ?(4-1.unx|4-2.unx)"
ls ?(4-1.unx|4-2.unx)
read -p 'press Enter'
echo -e "\nls ?(|lkjlj.unx)"
ls ?(|lkjlj.unx)
read -p 'press Enter'
echo -e "\nls @(4-1.unx|4-2.unx|4-3.unx)"
ls @(4-1.unx|4-2.unx|4-3.unx)
read -p 'press Enter'
echo -e "\n ls !(4-1.unx|4-2.unx|4-3.unx)"
ls !(4-1.unx|4-2.unx|4-3.unx)
echo
