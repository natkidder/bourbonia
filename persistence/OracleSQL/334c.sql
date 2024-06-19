-- creating a standalone procedure, which is then "execute"'d

create or replace procedure in_only(v_in number) is
v_result number default 17;
begin
  v_result := v_in * v_in;
  dbms_output.put_line('in went ' || v_in || ', still in is ' || v_result);
exception
  when others then null;
end;
/

-- you may execute these outside of PL/SQL because they don't return or
-- output a value

execute in_only(33);
exec in_only(48);
execute in_only(v_in=>73);
