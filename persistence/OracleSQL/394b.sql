declare
  -- a new datatype is born!
  type r_emp is record (
    my_empno emp.empno%type,
    my_ename emp.ename%type,
    my_job emp.job%type,
    my_sal emp.sal%type
    );
  type r_emp2 is record (
    my_empno emp.empno%type,
    my_ename emp.ename%type,
    my_job emp.job%type,
    my_sal emp.sal%type
    );
  employee r_emp;
  employee2 r_emp;
  employee3 r_emp2;
  -- assign variables to that datatype
begin
   -- assign values to one of those variables
   employee.my_empno := 7844;
   employee.my_ename := 'TURNER';
   employee.my_job := 'SALESMAN';
   employee.my_sal := 1500;
   -- assign one variable of that data type to the other
   employee2 := employee;
   -- this will fail because they are of two different record types
   -- the fact that the record types are identical makes no difference
   employee3 := employee;
end;
/
