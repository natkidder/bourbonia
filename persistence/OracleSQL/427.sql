/*
example of a cursor being set to a correlated subquery
*/
set echo off
select deptno, avg(sal) from emp group by deptno;
declare
  -- cursor is all employees who make more than the average in their dept
  cursor c_emp is
    select deptno, empno, sal
    from emp e
    where sal > (
      select avg(sal) from emp e2
      where e.empno = e2.empno
      )
    order by sal;
begin
  for v_emp in c_emp loop
    dbms_output.put_line(v_emp.deptno || '  ' || v_emp.empno 
         || '  ' || v_emp.sal);
  end loop;
end;
/
set echo on
