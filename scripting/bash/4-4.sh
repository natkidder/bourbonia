#list PATH one directory to a line
echo -e "  PATH is:\n"${PATH//:/'\n'}|sort
