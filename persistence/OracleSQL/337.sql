-- invoking a procedure that's part of a package

create or replace package package2 is
  procedure in_out2 (v_in in number, v_out out number);
end;
/
create or replace package body package2 is
  procedure in_out2 (v_in in number, v_out out number) is
  begin
    v_out := v_in * v_in;
  exception
    when others then null;
  end;
end;
/

-- NOTE: you must use the qualified name of the procedure here

declare
  v_into number default 71;   v_outof number;
begin
  package2.in_out2(v_into, v_outof);
  dbms_output.put_line('In goes ' || v_into || ', out comes ' || v_outof);
exception
  when others then null;
end;
/
