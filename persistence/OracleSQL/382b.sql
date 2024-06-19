/*
Using a table record-column to populate a variable, then using the variable to update a record-column.  Counteracts 382.sql
*/
declare
  my_empno emp.empno%type;
  my_comm emp.comm%type;
begin
  -- first fetch appropriate record
  select empno, comm 
  into my_empno, my_comm
  from emp where empno = 7844;
  dbms_output.put_line('Old Commission: ' || to_char(my_comm));

  -- now modify the record
  my_comm := my_comm - 1000;

  -- now modify the database
  update emp set comm = my_comm
  where empno = my_empno;

  -- tell me what I did
  dbms_output.put_line('New Commission: ' || to_char(my_comm));
end;
/
