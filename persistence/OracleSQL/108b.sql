rem  select employees who have at least one voucher > 1000

select ename, job
from emp
where empno in (
  select empno
  from expense
  where vouch_amt > 1000)
/
