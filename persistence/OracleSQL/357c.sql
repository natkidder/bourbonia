/*
illustrating a 'while-loop' statement
*/

declare
  x number := 1;
  y number := 1;
  z number := 1;
  s number;
  t number(10,7);
  d number(10,7);
begin
  while z < 10000 loop
    s := log(10,z);
    z := x + y;
    x := y;
    y := z;
    t := log(10,z);
    d := t - s;
    dbms_output.put_line('Fibonnacci sum: ' || to_char(z) || ', its log '
         || to_char(t) || ' delta log ' || to_char(d));
  end loop;
end;
/
