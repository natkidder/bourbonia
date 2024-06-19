/* illustrating in and out variables for procedures */

create or replace procedure in_out2 (v_in in number, v_out out number) is
begin
  v_out := v_in * v_in;
exception
  when others then null;
end;
/

-- you must run this from within PL/SQL code because it returns a value

declare
  v1 constant number(5) := 17; v2 number(11);
begin
  in_out2(v1,v2);
  dbms_output.put_line('In went ' || v1 || ', out came ' || v2);
exception
  when others then null;
end;
/
