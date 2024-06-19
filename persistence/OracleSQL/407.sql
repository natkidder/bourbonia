/*
how to populate a single element of a collection of records, and then reference each field within that element
*/
declare
  type ttyp_emp is table of emp%rowtype
    index by binary_integer;
  t_emp ttyp_emp;
begin
  select * into t_emp(1) from emp where empno = 7844;
  if t_emp(1).empno = 7844 then
    dbms_output.put_line(to_char(t_emp(1).empno) || '  ' || t_emp(1).ename ||
         '  ' || t_emp(1).job || '  ' || to_char(t_emp(1).sal));
  else
    dbms_output.put_line('no match');
  end if;
end;
