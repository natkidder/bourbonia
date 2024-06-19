declare
  -- a new datatype is born!
  p_employee emp%rowtype;
begin
  select * into p_employee
  from emp
  where empno = 7844;
  -------------
  dbms_output.put_line(to_char(p_employee.empno) || '  ' || p_employee.ename
       || '  ' || p_employee.job || '  ' || to_char(p_employee.sal));
end;
/
