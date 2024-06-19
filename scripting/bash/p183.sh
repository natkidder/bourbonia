## illustrates quoting and eval
tput clear
echo 'ls -l $train/p$((6+1))*.unx | cut -c44-'
ls -l $train/p$((6+1))*.unx | cut -c44-
echo -e "\n" 'cmnd='\''ls -l $train/p$((6+1))*.unx | cut -c44-'\'
cmnd='ls -l $train/p$((6+1))*.unx | cut -c44-'
echo '$cmnd'
$cmnd
echo -e '\n' 'eval $cmnd'
eval $cmnd
read -p 'Press Enter to continue'
echo -e '\n' '\''ls -l $train/p$((6+1))*.unx | cut -c44-'\'
'ls -l $train/p$((6+1))*.unx | cut -c44-'
echo -e '\n' '"ls -l $train/p$((6+1))*.unx | cut -c44-"'
"ls -l $train/p$((6+1))*.unx | cut -c44-"
echo -e '\n' '"ls -l $train/p75.unx | cut -c$((40+4))-"'
"ls -l $train/p75.unx | cut -c$((40+4))-"
echo -e '\n' '"ls -al ~/.bash_profile"'
"ls -al ~/.bash_profile"
echo -e '\n' '"ls -al /home/nkidder/.bash_profile"'
"ls -al /home/nkidder/.bash_profile"
echo -e '\n' 'ls -al /home/nkidder/.bash_profile'
ls -al /home/nkidder/.bash_profile
read 
echo -e '\n' 'set -o xtrace'
echo -e '\n' 'ls -l $train/p$((6+1))*.unx | cut -c44-'
set -o xtrace
ls -l $train/p$((6+1))*.unx | cut -c44-
echo
echo -e '\n' 'set +o xtrace'
set +o xtrace
echo -e '\neval '\''ls -l $train/p$((6+1))*.unx | cut -c44-'\'
eval 'ls -l $train/p$((6+1))*.unx | cut -c44-'
