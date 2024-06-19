# illustrates string operators on variables
source ~/.functions
cls
trap 'echo Trapping the ERR fake signal' ERR
trap 'echo Trapping the EXIT fake signal' EXIT
trap 'echo Trapping the RETURN fake signal' RETURN
echo -e '\n' 'test='\''test value'\'
test='test value'
read -p '${test:-test not defined}'
echo -e '\n' ${test:-test not defined}
read -p '${test2:-test2 not defined}'
echo -e '\n' ${test2:-test2 not defined}
read -p '${test2:=test2 value}'
echo -e '\n' ${test2:=test2 value}
read -p '${test:?test not defined, exiting}'
echo -e '\n' ${test:?test not defined, exiting}
read -p '${test:+test exists}'
echo -e '\n' ${test:+test exists} '\n'
read -p '${test2:+test2 exists}'
echo -e '\n' ${test2:+test2 exists}
read -p '${test3:+test3 exists}'
echo -e '\n' ${test3:+test3 exists}
read -p '${test2:?test2 not defined, exiting}'
echo -e '\n' ${test2:?test2 not defined, exiting}
read -p '${test:5:${#test}-5}'
echo -e '\n' ${test:5:${#test}-5}
read -p '${!C*}'
echo -e '\n' ${!C*}
read -p '${!C@}'
echo -e '\n' ${!C@}
read -p '${test3:?test3 not defined, exiting}'
echo -e '\n' ${test3:?test3 not defined, exiting}
trap - ERR EXIT RETURN
