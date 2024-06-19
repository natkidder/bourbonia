rem  select employees who have at least one voucher > 1000
rem  compare with 108b

select e.ename, e.job
from emp e
where exists (
  select vouch_amt
  from expense x
  where x.empno = e.empno
  and x.vouch_amt > 1000)
/
