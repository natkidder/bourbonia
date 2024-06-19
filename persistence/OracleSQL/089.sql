select e.empno, e.ename, e.job
from emp e, emp e2
where e.empno ^= e2.empno and
e.ename = e2.ename
and e.job = e2.job
and e.mgr = e2.mgr
/
