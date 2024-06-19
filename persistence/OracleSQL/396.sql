/*
declaring sub-record datatypes, assigning them to variable, and populating them
*/

declare
  -- two new datatypes are born
  type t_addr is record (
    street varchar2(50),
    city varchar2(50),
    state varchar2(50),
    post number
    );
  type t_emp is record (
    my_empno emp.empno%type,
    my_ename emp.ename%type,
    my_job emp.job%type,
    my_sal emp.sal%type,
    my_addr t_addr
    );
  -- a variable or that type
  employee t_emp;
begin
  employee.my_empno := 7844;
  employee.my_ename := 'TURNER';
  employee.my_job := 'SALESMAN';
  employee.my_sal := 1500;
  employee.my_addr.street := '25 PEACH STREET';
  employee.my_addr.city   := 'ST. LOUIS';
  employee.my_addr.state  := 'MISSOURI';
  employee.my_addr.post   := '55555';
end;
/
