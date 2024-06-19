select ename || ' does the ' || 
rpad(
  decode(job, 'ANALYST', 'analyzing', 'CLERK', 'filing', 'MANAGER',
 'managing', 'PRESIDENT', 'bossing around', 'SALESMAN', 'golfing',
'goofing off'),10,'-')
 as job from emp
/
