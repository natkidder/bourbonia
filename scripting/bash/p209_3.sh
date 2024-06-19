## illustrates having 2 different traps, one in a separate function, one as a 
## simple command.  

FunctTrap ()
{
  trap "echo 'INT trap invoked via its own function'" INT
}

trap "echo 'INT trap invoke via a simple cmd line'" INT
echo 'press ctrl-c'
echo 'to terminate, try kill -TERM to the PPID of the sleep process from another shell'
FunctTrap
while true; do
  sleep .1
done
trap - INT
