-- example of predefined exception

declare
  v_empno number;
begin
  select empno into v_empno
  from emp
  where ename = 'LJKLKJLKJ'; 
  dbms_output.put_line('Smithers emp no. is ' || v_empno);
exception
  when no_data_found then
    dbms_output.put_line('LJKLKJLKJ no longer here');
    dbms_output.put_line(sqlcode || ', ' || sqlerrm(sqlcode));
end;
