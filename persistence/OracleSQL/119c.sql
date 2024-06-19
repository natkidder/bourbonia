select d.deptno, avg(sal)
from emp e, (
  select deptno
  from dept
  where loc = 'NEW YORK'
  ) d
where e.deptno = d.deptno
group by d.deptno
