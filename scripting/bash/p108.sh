# illustrate if-else-fi and command exit status
tput clear
echo ' if ls *.ppt; then'
echo '   echo Powerpoint files in this directory tree'
echo ' elif ls *.doc; then'
echo '   echo Word files in this directory tree'
echo ' elif ls *.xls; then'
echo '   echo Excel files in this directory tree'
echo ' else'
echo '   echo neither Unix script nor flat text files in this directory'
echo ' fi'
echo
if ls *.ppt; then
  echo Powerpoint files in this directory tree
elif ls *.doc; then
  echo Word files in this directory tree
elif ls *.xls; then
  echo Excel files in this directory tree
else
  echo neither Unix script nor flat text files in this directory
fi
echo
