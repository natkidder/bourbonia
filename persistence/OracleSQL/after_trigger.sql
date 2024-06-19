create or replace trigger after_golf_p2
after insert or update or delete on golf_p2
begin
  dbms_output.put_line('after insert, update or delete of golf_p2');
exception
  when others then null;
end;
