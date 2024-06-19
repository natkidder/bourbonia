/*
committing changes to a table row through PL/SQL
*/

declare
  my_empno emp.empno%type;  my_comm emp.comm%type;
begin
  -- first, fetch appropriate record
  commit;
  dbms_transaction.read_write;
  select empno, comm
  into my_empno, my_comm
  from emp
  where empno = 7844;
   dbms_output.put_line('Old commission was $' || to_char(my_comm));
  -- modify the holding variable
  my_comm := my_comm - 1000;
  -- repopulate it into the table
  update emp set comm = my_comm
  where empno = my_empno;
  -- commit changes
  commit;
  -- confirm to user change is complete
  dbms_output.put_line('New commission is  $' || to_char(my_comm));
end;
/
