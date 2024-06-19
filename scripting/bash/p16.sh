# illustrates I/O redirection; this works the same as cp

if [ -z "$1" ] || [ -z "$2" ]; then
  echo "2 arguments: source and dest file names"
  exit -1
fi
cat < "$1" > "$2"
