begin
  <<month_loop>>
  for i in reverse 1..12 loop
    dbms_output.put_line(month_loop.i);
  end loop month_loop;
end;
/
