/*
loop using an 'exit when' clause
*/

declare
  x number := 1;
  y number := 1;
  z number;
  i number := 0;
begin
  dbms_output.put_line('number 1 of Fibbinacci sequence: ' || to_char(x));
  dbms_output.put_line('number 2 of Fibbinacci sequence: ' || to_char(y));
  i := 2;
  loop
    z := x + y;
    x := y;
    y := z;
    i := i + 1;
    dbms_output.put_line('number ' || to_char(i) || ' of Fibbinacci sequence: '
         || to_char(z));
    exit when i > 15;
  end loop;
end;
/
