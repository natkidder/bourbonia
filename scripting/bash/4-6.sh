# examples of command substitution
# mail everyone who is currently logged in
#mail $(who | cut -f1 -d' ')
#
# open excel for all spreadsheets in a directory
cd c:/mydocs/home/emily
xl.unx $(ls *${1}*.xls)
cd - 
