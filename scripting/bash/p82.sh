#source versus just the filename argument
source ~/.functions
cls
echo 'P82='\''P82 shell variable value'\'
P82='P82 shell variable value'
echo './p82-1.unx'
./p82-1.unx
echo 'source p82-1.unx'
source p82-1.unx
echo -e "\n"
echo 'export P82='\''P82 shell variable value'\'
export P82='P82 shell variable value'
echo './p82-1.unx'
./p82-1.unx
echo 'source p82-1.unx'
source p82-1.unx
echo
