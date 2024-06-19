-- simple fetch

declare
  my_empno number(4); my_ename varchar2(10);
  my_job varchar2(9); my_sal number(7,2);
begin
  select empno, ename, job, sal
  into my_empno, my_ename, my_job, my_sal
  from emp
  where empno = 7844;

  dbms_output.put_line(to_char(my_empno) || '  ' || my_ename);
  dbms_output.put_line(my_job || '  ' || to_char(my_sal));
end;
/
