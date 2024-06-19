/*
populating a nested table row directly from a SQL table
*/
declare
  type ttype_emp is table of emp%rowtype
    index by binary_integer;
  t_emp ttype_emp;
begin
  select * into t_emp(1) from emp where empno = 7844;
end;
