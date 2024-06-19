declare
  -- a new datatype is born!
  type r_emp is record (
    my_empno emp.empno%type,
    my_ename emp.ename%type,
    my_job emp.job%type,
    my_sal emp.sal%type
    );
  employee r_emp;
  employee2 r_emp;
  -- assign variables to that datatype
begin
   -- assign values to one of those variables
   employee.my_empno := 7844;
   employee.my_ename := 'TURNER';
   employee.my_job := 'SALESMAN';
   employee.my_sal := 1500;
   -- assign one variable of that data type to the other
   employee2 := employee;
end;
/
