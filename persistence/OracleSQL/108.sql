rem select employees whose total voucher amounts exceed their expenses

select e.ename, e.sal
  from emp e
  where sal < (
    select sum(x.vouch_amt)
    from expense x
    where e.empno = x.empno)
/
