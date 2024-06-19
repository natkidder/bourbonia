# illustrates arithmetic operators
declare -i i=6
echo 'i = '		$((i))
echo 'i++: '		$((i++))
echo '--i: '		$((--i))
echo 'i = '		$((i))
echo
echo 'i+1: '		$((i+1))
echo 'i-2: '		$((i-2))
echo 'i*3: '		$((i*3))
echo 'i/2: '		$((i/2))
echo 'i%3: '		$((i%3))
echo 'i**2: '		$((i**2))
echo
echo 'i<<1: '		$((i<<1))
echo 'i>>1: '		$((i>>1))
echo 'i&1: '		$((i&1))
echo 'i|1: '		$((i|1))
echo '~i: '		$((~i))
echo '!i: '		$((!i))
echo 'i^1: '		$((i^1))
echo 'i,1: '		$((i,1))
