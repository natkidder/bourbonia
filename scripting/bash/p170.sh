## illustrates printf
tput clear
echo 'printf "%b\n" '\''osman\npasha'\'
printf "%b\n" 'osman\npasha'
echo 'printf "%c\n" osman pasha'
printf "%c\n" osman pasha
echo 'printf "%c%c\n" osman pasha'
printf "%c%c\n" osman pasha
echo 'printf "%d\n" 31415'
printf "%d\n" 31415
echo 'printf "%i\n" 17'
printf "%i\n" 17
printf "\n"
echo 'printf "%+4.3e\n" 45.6789'
printf "%+4.3e\n" 45.6789
echo 'printf "% 4.3E\n" 45.6789'
printf "% 4.3E\n" 45.6789
echo 'printf "%#4.3f\n" 45.6789'
printf "%#4.3f\n" -45.6789
echo 'printf "%09.3g\n" 45.6789'
printf "%09.3g\n" 45.6789
echo 'printf "%-4.5G\n" 45.6789'
printf "%-4.5G\n" 45.6789
printf "\n"
read -p 'Press <Enter> to continue'
echo 'printf "%o\n" 15'
printf "%o\n" 15
echo 'printf "%q\n" '\''the sun never sets'\'
printf "%q\n" 'the sun never sets'
echo 'printf "%s\n" never say never'
printf "%s\n" never say never
echo 'printf "%11s\n" never say never'
printf "%11s\n" never say never
echo 'printf "%u\n" -7'
printf "%u\n" -7
printf "\n"
echo 'printf "%u\n" 7'
printf "%u\n" 7
echo 'printf "%x\n" 31'
printf "%x\n" 31
echo 'printf "%X\n" -46'
printf "%X\n" -46
echo 'printf "%i%%\n" 5'
printf "%i%%\n" 5
echo 'printf "|%12s|\n" blah'
printf "|%12s|\n" blah
printf "\n"
echo 'printf "|%-12s|\n" blah'
printf "|%-12s|\n" blah
