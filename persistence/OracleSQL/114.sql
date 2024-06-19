select ename, deptno, sal
from emp e
where (deptno, sal) in (
  select deptno, max(sal)
  from emp e2
  group by deptno
  )
order by deptno
/
