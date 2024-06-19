-- illustrating a single 'in out' variable

create or replace procedure in_out (v_io in out number) is
begin
  v_io := v_io + 1;
exception
  when others then null;
end;
/

-- you must run the procedure from within PL/SQL code because it returns or
-- outputs a value

declare
  v1 number default 5;
begin
  dbms_output.put_line('v1 before in_out is ' || v1);
  in_out(v1);
  dbms_output.put_line('v1 after in_out is ' || v1);
exception
  when others then null;
end;
/
