## illustrates interactive read
if test ${0##*/} = InteractiveRead.unx; then
  echo source ${0##*/}
  exit 2
fi
tput clear
IFS=,
echo 'Enter a comma-delimited array'
echo 'read -a ReadArray'
read -a ReadArray
echo 1st 2 elements: ${ReadArray[0]} ${ReadArray[1]}

echo 'enter a string, terminated with a #'
echo 'read -d# ReadString'
read -d# ReadString

bind '"\M-t":"Entered String for read"'
echo -e '\n' 'Press Esc, then t, then Enter' 
read -e ReadString 
echo ReadString=$ReadString
bind -r "\M-t"

echo -e '\n' 'enter a date YYYYMMDD format'
echo 'read -n 8 ReadDate'
read -n 8 ReadDate
echo -e '\n' You entered ${ReadDate:4:2}/${ReadDate:6:2}/${ReadDate:0:4}

echo 'read -p '\''File to search for: '\'' filename'
read -p 'File to search for: ' filename
find . -mtime -9999 -print | grep -i "$filename"

echo -e '\n' 'Enter a string with an escape sequence'
read -r ReadString 
echo ReadString="$ReadString"

echo 'read -p '\''Enter password: '\'' -s ReadPwd'
read -p 'Enter password: ' -s ReadPwd
echo -e '\n' Your password is: $ReadPwd

echo 'read -p '\''You have 10 seconds to enter the destruct sequence: '\'' -t 10 $DestructSeq'
read -p 'You have 10 seconds to enter the destruct sequence: ' -t 10 $DestructSeq
echo -e '\n' 
