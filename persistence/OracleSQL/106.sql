select e.ename, e.deptno, e.job, e.sal
from emp e
where exists (
  select deptno
  from dept d
  where rent < 1750
  and d.deptno = e.deptno)
/
