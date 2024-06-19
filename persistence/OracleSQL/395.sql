/*
adding data to a variable of record type
*/

declare
  -- a new datatype is born!
  type t_emp is record (
    my_empno emp.empno%type,
    my_ename emp.ename%type,
    my_job emp.job%type,
    my_sal emp.sal%type
    );
  -- a variable of that type
  employee t_emp;
begin
  select empno, ename, job, sal
  into employee.my_empno, employee.my_ename, employee.my_job, employee.my_sal
  from emp
  where empno = 7844;
  -- display results
     dbms_output.put_line(to_char(employee.my_empno) || '  ' || employee.my_ename ||
          '  ' || employee.my_job || '  ' || to_char(employee.my_sal));
end;
/
