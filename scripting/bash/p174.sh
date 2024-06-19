# illustrates what happens when the variable read reads into don't match the input
read a b c<<xxxxx
1 2
xxxxx
echo a=$a b=$b c=$c REPLY=$REPLY

read d e f<<xxxxx
1 2 3 4
xxxxx
echo d=$d e=$e f=\"$f\" REPLY=\"$REPLY\"

read <<yyyyy
1 2 3 4
yyyyy
echo REPLY=\"$REPLY\"
