/*
Fibbinacci sequence using a loop with an 'exit when' clause
*/

declare
  x number := 1;
  y number := 1;
  z number;
begin
  loop
    z := x + y;
    x := y;
    y := z;
    dbms_output.put_line('Fibbinacci sequence: ' || to_char(z));
    exit when z > 2000;
  end loop;
end;
/
