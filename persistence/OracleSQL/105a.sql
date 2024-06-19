select ename, deptno, job, sal
from emp
where sal > (
select avg(sal) from emp)
/
