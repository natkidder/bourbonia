# demonstrates the length operator for shell variables
echo length of PATH is ${#PATH}
echo -e '\n' 'Path=${PATH//:/'\'\''}'
Path=${PATH//:/''}
echo length of PATH without delimiters is ${#Path}
aphorism='what is right is more important than who is right'
echo aphorism is "'$aphorism'"
echo -e 'length of aphorism is ${#aphorism}'
echo length of aphorism is ${#aphorism}
echo
