-- inserting a record

declare
  my_empno emp.empno%type default 1234;
  my_ename emp.ename%type default 'SMITHERS';
  my_job emp.job%type default 'MANAGER';
begin
  insert into emp (empno, ename, job) values (my_empno, my_ename, my_job);
end;
/
