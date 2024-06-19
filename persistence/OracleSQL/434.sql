/* more user-defined errors */

declare
  cursor c_emp is select * from emp where job = 'SALESMAN';
  v_empno number;
  v_bad_empno emp.empno%type;
  v_bad_ename emp.ename%type;
  comm_null exception;
begin
-- not sure what the following line does, except to raise a no_data_found exc.
---  select empno into v_empno from emp where ename = 'SMITHERS';
  for v_emp in c_emp loop
    if v_emp.comm is null then
      v_bad_empno := v_emp.empno;
      v_bad_ename := v_emp.ename;
      raise comm_null;
    end if;
  end loop;
exception
  when comm_null then
    dbms_output.put_line('Salesman ' || v_bad_empno || ', named ' ||
         v_bad_ename || ' has no commission');
---  when no_data_found then
---    dbms_output.put_line('no data found in Smithers query');
  when others then
    dbms_output.put_line('An unspecified error occured');
end;
/
