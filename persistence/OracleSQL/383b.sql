/*
deleting a record.  Roundabout, but you could insert a confirmation stmt somewhere in the middle
*/

declare
  my_empno emp.empno%type;
begin
  select empno into my_empno
  from emp
  where ename = 'SMITHERS' and job = 'MANAGER';
  -- now delete the record
  delete from emp
  where empno = my_empno;
end;
/
