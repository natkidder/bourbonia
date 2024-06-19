/*
illustrating passing parameters to cursors.  Opposes 421b.
*/
set echo off
select empno, sal from emp where empno between 7600 and 7700;

declare
  cursor c_emp(l_empno in number, h_empno in number) is
    select * from emp where empno between l_empno and h_empno;
  v_emp emp%rowtype;
begin
  open c_emp(7600, 7700);
  loop
    fetch c_emp into v_emp;
    exit when c_emp%notfound;
    if v_emp.job = 'CLERK' then v_emp.sal := v_emp.sal / 1.05;
      elsif v_emp.job = 'ANALYST' then v_emp.sal := v_emp.sal / 1.03;
      elsif v_emp.job = 'SALESMAN' then v_emp.sal := v_emp.sal / 1.12;
      elsif v_emp.job = 'PRESIDENT' then v_emp.sal := v_emp.sal / 1.20;
    end if;
    update emp set sal = v_emp.sal
      where empno = v_emp.empno;
  end loop;
end;
/
declare
  cursor c_emp(l_empno in number, h_empno in number) is
    select * from emp where empno between l_empno and h_empno;
  v_emp emp%rowtype;
begin
  open c_emp(7600, 7700);
  loop
    fetch c_emp into v_emp;
    exit when c_emp%notfound;   
    dbms_output.put_line(v_emp.empno || '  ' || to_char(v_emp.sal));
  end loop;
  close c_emp;
end;
/
set echo on
