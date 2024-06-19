rem  this lists all depts & jobs who average salary is greater than that of Martin

select deptno, job, avg(sal)
from emp
group by deptno, job
having avg(sal) > (
  select sal
  from emp
  where ename = 'MARTIN'
  )
order by avg(sal)
/
