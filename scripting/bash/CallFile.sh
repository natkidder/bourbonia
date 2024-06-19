# from LTBS, page 115
echo ' ReverseStatus.unx:'
cat ReverseStatus.unx
read -p '  press enter'
./ReverseStatus.unx  # should return a 1
echo "./ReverseStatus.unx w/o args returns a $?"
./ReverseStatus.unx 'lljljkl'
echo "-z is an invalid option to ls, but ./ReverseStatus.unx 'ls -z' returns a $?"
./ReverseStatus.unx 'ls -z'
echo "-z is an invalid option to ls, but ./ReverseStatus.unx 'ls -z' returns a $?"
./ReverseStatus.unx 'ls -C *.txt'
echo "-C is a valid option to ls, so ./ReverseStatus.unx 'ls -C *.txt' returns a $?"
