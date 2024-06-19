## illustrates how to create an orphan, at least in theory
SleepyTime ()
{
  sleep 30 &
  ls -l > p214-1.txt
}
SleepyTime
echo -e '\n' 'In theory, the sleep process should be an orphan'
jobs
ps -a
