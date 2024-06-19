/*
loop-exit construct to product all the fibonnaci numbers < 1000
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
    dbms_output.put_line('Fibinacci Number: ' || to_char(z));
    if z > 1000 then exit;
    end if;
  end loop;
end;
/
