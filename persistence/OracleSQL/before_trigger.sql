/*
illustrating a 'before' trigger on a table
*/

create or replace trigger bef_del_golf_p2
before insert or update or delete on golf_p2
begin
  dbms_output.put_line('before insert or update or delete on golf_p2');
exception
  when others then null;
end;

/
