/* illustrates a trigger that fires after logging on to the database */

create or replace trigger after_logon
after logon on database
begin
  dbms_output.put_line('you just logged on to the database');
end;
