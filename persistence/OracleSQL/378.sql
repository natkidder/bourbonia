-- mgr is a column of datatype number(4) --> errors

declare
  my_empno number(4); my_ename varchar2(10); my_job varchar2(9);
  my_sal number(7,2); my_mgr number(2);
begin
  select empno, ename, job, sal, mgr
  into my_empno, my_ename, my_job, my_sal, my_mgr
  from emp
  where empno = 7844;
  dbms_output.put_line(to_char(my_empno) || '  ' || my_ename);
  dbms_output.put_line(my_job || '  ' || to_char(my_sal));
  dbms_output.put_line(to_char(my_mgr));
end;
/
