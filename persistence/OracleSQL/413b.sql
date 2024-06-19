/*
illustrating explicit cursors and records
*/

select empno, job, sal from emp order by empno;

declare
  cursor c_emp is select empno, job, sal from emp;
  type rtyp_emp is record (
    v_empno emp.empno%type,
    v_job emp.job%type,
    v_sal emp.sal%type
    );
  r_emp rtyp_emp;

begin
  open c_emp;
  loop
    fetch c_emp into r_emp;
    exit when c_emp%notfound;
    if r_emp.v_job = 'CLERK' then r_emp.v_sal := r_emp.v_sal / 1.05;
      elsif r_emp.v_job = 'ANALYST' then r_emp.v_sal := r_emp.v_sal / 1.03;
      elsif r_emp.v_job = 'SALESMAN' then r_emp.v_sal := r_emp.v_sal / 1.12;
      elsif r_emp.v_job = 'PRESIDENT' then r_emp.v_sal := r_emp.v_sal / 1.20;
    end if;
    update emp set sal = r_emp.v_sal
      where empno = r_emp.v_empno;
  end loop;
  close c_emp;
  commit;
end;
/

declare
  cursor c_emp is select empno, job, sal from emp order by empno;
  type rtyp_emp is record (
    v_empno emp.empno%type,
    v_job emp.job%type,
    v_sal emp.sal%type
    );
  r_emp rtyp_emp;
begin
  open c_emp;
  loop
    fetch c_emp into r_emp;
    exit when c_emp%notfound;
    dbms_output.put_line(to_char(r_emp.v_empno) || '  ' || r_emp.v_job 
         || '  ' || to_char(r_emp.v_sal));
  end loop;
  close c_emp;
end;
/
