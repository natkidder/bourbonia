# illustrates let
trap "Problem at line $LINENO" ERR
declare -a ArrayVar

echo -e '\n' '  let ArrayVar[0]=1'
let ArrayVar[0]=1
echo 'ArrayVar[0]='${ArrayVar[0]}

echo -e '\n' '  let ArrayVar[0]=ArrayVar[0]+1'
let ArrayVar[0]=ArrayVar[0]+1
echo 'ArrayVar[0]='${ArrayVar[0]}
let ArrayVar[1]=3
echo 'ArrayVar[1]'=${ArrayVar[1]}

echo -e '\n' '  let ArrayVar[0]=ArrayVar[0]+ArrayVar[1]'
let ArrayVar[0]=ArrayVar[0]+ArrayVar[1]
echo 'ArrayVar[0]='${ArrayVar[0]}

echo -e '\n' '  let ArrayVar[0]=ArrayVar[0]+${ArrayVar[1]}'
let ArrayVar[0]=ArrayVar[0]+${ArrayVar[1]}
echo 'ArrayVar[0]='${ArrayVar[0]}

echo -e '\n' '  let ArrayVar[0]=$((ArrayVar[0]+ArrayVar[1]))'
let ArrayVar[0]=$((ArrayVar[0]+ArrayVar[1]))
echo 'ArrayVar[0]='${ArrayVar[0]}

echo -e '\n' '  let ArrayVar[0]=$((ArrayVar[0]+${ArrayVar[1]}))'
let ArrayVar[0]=$((ArrayVar[0]+${ArrayVar[1]}))
echo 'ArrayVar[0]='${ArrayVar[0]}
