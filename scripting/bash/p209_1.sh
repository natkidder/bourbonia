## illustrating trapping scope.  functions are part of the shell that invokes them
## traps defined in the function will be recognized by the invoking shell
settrap() 
{
  trap "echo 'ctrl-c: trap defined in a separate function'" INT
}

settrap
echo 'press ctrl-c'
echo 'to end the loop, kill -INT the PPID of sleep from another shell'
while true; do
  sleep .03
done 
trap - INT
