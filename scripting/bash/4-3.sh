# showing the PATH variable with all the directories separated by newlines
# rather than colons
# illustates text substitution

echo 'PATH broken by lines'
echo -e ${PATH//:/'\n'}
