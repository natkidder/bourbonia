/*
shows locality and globality of variables intrinsically declared in nested loops.
*/

declare
  /* nothing to declare */
begin
  for x in 1..5 loop
    for y in 1..5 loop
-- legal, as x is global to y's for-loop
      dbms_output.put_line('x is ' || to_char(x) || ', y is ' || to_char(y));
    end loop;
-- illegal, as y is local to it's for-loop
    dbms_output.put_line('x is ' || to_char(x) || ', y is ' || to_char(y));
  end loop;
end;
/
