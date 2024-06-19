## illustrates named pipes & process substitution
##note: run this at the command prompt instead
#diff <(ls) <(ls -rt)
diff <$(ls) <$(ls -rt)
