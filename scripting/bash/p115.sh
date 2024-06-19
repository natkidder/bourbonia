# demonstrates called scripts and functions that openly return a value
# calling script
tput clear
echo 'cat p115-1.unx'
echo ' if ./p115-1.unx golf.txt; then'
echo '   echo "subsidiary scripts ran normally"'
echo ' else'
echo '   echo "subsidiary script experienced an anomaly"'
echo ' fi'
echo

cat p115-1.unx
if ./p115-1.unx golf.txt; then
  echo "subsidiary scripts ran normally"
else
  echo "subsidiary script experienced an anomaly"
fi
echo
