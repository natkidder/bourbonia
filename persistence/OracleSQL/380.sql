-- example of using the %type modifier

declare
  my_empno emp.empno%type;  my_ename emp.ename%type;   my_job emp.job%type;
  my_sal emp.sal%type;   my_mgr emp.mgr%type;
begin
  select empno, ename, job, sal, mgr
  into my_empno, my_ename, my_job, my_sal, my_mgr
  from emp
  where empno = 7844;
  dbms_output.put_line(to_char(my_empno) || '  ' || my_ename);
  dbms_output.put_line(my_job || '  ' || to_char(my_sal));
  dbms_output.put_line(to_char(my_mgr));
end;
/
