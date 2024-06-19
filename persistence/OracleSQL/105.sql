select ename, job, deptno, sal
from emp
where deptno in (
  select deptno
  from dept
  where rent < 1750)
/
