/*
illustrating explicit cursor parameters in the for..loop context.  Opposes 422.sql
*/
set echo off
select empno, job, sal from emp 
where empno between 7700 and 7800
order by empno;

declare
  cursor c_emp (l_empno in number, h_empno in number) is
    select * from emp where empno between l_empno and h_empno; 
begin
  for v_emp in c_emp(7700, 7800) loop
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

column v_emp.empno format a10 heading 'EMP NO.'
column v_emp.job format a15 heading 'JOB'
column v_emp.sal format a10 heading 'SAL/WK'
declare
  cursor c_emp (l_empno number, h_empno number) is
    select * from emp where empno between l_empno and h_empno
    order by empno;
begin
  for v_emp in c_emp(7700, 7800) loop
    dbms_output.put_line(v_emp.empno || '   ' || v_emp.job || 
         '  ' || v_emp.sal);
  end loop;
end;
/
set echo on
