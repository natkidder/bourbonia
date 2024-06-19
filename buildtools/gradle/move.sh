if [ $# -lt 2 ];then
    echo "arg1   prefix of file to move to build.gradle    arg2  task to run"
    exit 1
fi
cp $1.gradle build.gradle
gradle -q $2
