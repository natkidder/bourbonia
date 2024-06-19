declare
  e_sample exception;
begin
  raise e_sample;
exception
  when e_sample then
    dbms_output.put_line('exception trapped');
end;
/
