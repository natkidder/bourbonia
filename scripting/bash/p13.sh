#illustrates brace expansion
source ~/.functions
cls
echo ''\''echo b{ed,olt,ar}s'\'''
echo b{ed,olt,ar}s
echo
echo ''\''echo {3..7}'\'''
echo {3..7}
echo
echo ''\''echo {b..d}'\'''
echo {b..d}
echo
echo ''\''echo {b..d}ash'\'''
echo {b..d}ash
echo
echo ''\''echo {b..d,l..n}'\'''
echo {b..d,l..n}
echo
echo ''\''echo {b..d,g,h,l..n}'\'''
echo {b..d,g,h,l..n}
echo
echo ''\''echo {b..d,g,h,l..n}ash'\'''
echo {b..d,g,h,l..n}ash
echo
echo ''\''ls *{g,m}.*'\'''
ls *{g,m}.*
echo
