-- nesting PL/SQL blocks

create or replace procedure no_op is
/* declare your variables here */
begin
  null;
  begin
    null;
  exception
   when others then null;
  end;
exception
  when others then null;
end;
/
