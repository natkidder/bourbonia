# illustrates integer conditionals
#echo enter a positive number:
echo ' read -p '\''enter a positive number: '\'' Nbr'
echo ' if [ $Nbr -lt $$ ]; then'
echo '   echo "$Nbr is less than the current shell process number, which is $$"'
echo ' elif [ $Nbr -eq $$ ]; then'
echo '   echo "$Nbr is equal to the current shell process number, which is $$"'
echo ' elif [ $Nbr -gt $$ ]; then'
echo '   echo "$Nbr is greater than the current shell process number, which is $$"'
echo ' fi'
echo
read -p 'enter a positive number: ' Nbr
if [ $Nbr -lt $$ ]; then
  echo "$Nbr is less than the current shell process number, which is $$"
elif [ $Nbr -eq $$ ]; then
  echo "$Nbr is equal to the current shell process number, which is $$"
elif [ $Nbr -gt $$ ]; then
  echo "$Nbr is greater than the current shell process number, which is $$"
fi
echo
