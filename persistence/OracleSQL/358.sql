-- demonstrating nested loops

declare
  -- nothing to declare
begin
  for x in 0..5 loop
    for y in reverse 0..x loop
      dbms_output.put_line('y is ' || to_char(y));
    end loop;
    dbms_output.put_line('-');
  end loop;
end;
/
