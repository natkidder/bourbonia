## illustrates setting traps both inside and outside of functions
SleepWithTrap ()
{
  trap "echo 'INT trap defined inside same function as job'" INT
  echo press ctrl-c now
  echo to kill it kill both the sleep and the shell from another shell
  while true; do
    sleep .03
  done
}

trap "echo 'INT trap defined outside of any functions or code blocks'" INT
SleepWithTrap
trap - INT
