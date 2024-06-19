# using while and until
pwd=$PWD/
echo PWD=$pwd ####
OneTab="\t"
prePwd=x
while [ $prePwd ]; do
  prePwd=${pwd#/*/}
  prePwd=${pwd%$prePwd}
  prePwd=${prePwd#/}
  prePwd=${prePwd%/}
  pwd=/${pwd#/*/}
  echo -e $tab $prePwd
  tab=$tab$OneTab
done
echo
read -p 'press Enter'

#until
pwd=$PWD
declare -i i=0
until [ $((i)) -gt ${#pwd} ]; do
  echo -e ${pwd:i:1} "\t" $((i++))
done
