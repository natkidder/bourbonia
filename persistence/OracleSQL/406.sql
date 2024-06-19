/*
populating a nested table with a record
*/
declare
  type rtype_emp is record (
    empno emp.empno%type,
    ename emp.ename%type,
    job emp.job%type,
    sal emp.sal%type
    );
  r_emp rtype_emp;
  type ttype_emp is table of rtype_emp;
  t_emp ttype_emp;
begin
  r_emp.empno := 7844;
  r_emp.ename := 'TURNER';
  r_emp.job   := 'SALESMAN';
  r_emp.sal   := 1500;
  t_emp := ttype_emp(r_emp);
end;
/
