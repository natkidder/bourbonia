/*
example of a cursor for loop without the defined cursor. Opposes 418.
*/
set echo off
select empno, sal from emp order by empno;

declare
  -- nothing to declare
begin
  dbms_transaction.read_write;
  for v_emp in (select * from emp) loop
    if v_emp.job = 'CLERK' then v_emp.sal := v_emp.sal / 1.05;
      elsif v_emp.job = 'ANALYST' then v_emp.sal := v_emp.sal / 1.03;
      elsif v_emp.job = 'SALESMAN' then v_emp.sal := v_emp.sal / 1.12;
      elsif v_emp.job = 'PRESIDENT' then v_emp.sal := v_emp.sal / 1.20;
    end if;
    update emp set sal = v_emp.sal
      where empno = v_emp.empno;
  end loop;
  commit;
end;
/

declare
  -- nothing to declare
begin
  for v_emp in (select * from emp order by empno) loop
    dbms_output.put_line(v_emp.empno || '   ' || to_char(v_emp.sal));
  end loop;
end;
/

set echo on
