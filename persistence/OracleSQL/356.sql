/*
Illustrating the use of loop-exit statments.  The loop is bounded by 'loop' and end loop'.  You need the exit or it will run forever.  Kind of a dangerous construct.
*/

declare
  x number default 0;
begin
  loop
    dbms_output.put_line('Did this ' || to_char(x) || ' times');
    x := x + 1;
    if x > 5 then exit;
    end if;
  end loop;
end;
/
