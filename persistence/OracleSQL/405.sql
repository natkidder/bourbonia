/*
shows how to declare a nested table of records
*/
declare
  type emptype is record (
    empno emp.empno%type,
    ename emp.ename%type,
    job emp.job%type,
    sal emp.sal%type
    );
  type emptbl is table of emptype;
  t_emp emptbl;
begin
  null;
end;
/
