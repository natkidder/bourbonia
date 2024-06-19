declare
  cursor c_emps is select empno, job, sal from emp; -- step 1: declare
  v_empno emp.empno%type;
  v_job emp.job%type;
  v_sal emp.sal%type;

begin
  open c_emps; -- step 2: open
  
  loop
    fetch c_emps into v_empno, v_job, v_sal;  -- step 3: fetch
    exit when c_emps%notfound;
    if v_job = 'CLERK' then v_sal := v_sal * 1.05;
      elsif v_job = 'ANALYST' then v_sal := v_sal * 1.03;
      elsif v_job = 'SALESMAN' then v_sal := v_sal * 1.12;
      elsif v_job = 'PRESIDENT' then v_sal := v_sal * 1.20;
    end if;
    -- SQL stmt
    update emp set sal = v_sal
      where empno = v_empno;
    end loop;

  close c_emps;  -- step 4, close
  commit;
end;
/
