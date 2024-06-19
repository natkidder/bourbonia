-- using the elseif construct

declare
  -- nothing to declare
begin
  for age in 1..99 loop
    if age between 1 and 5 then
      dbms_output.put_line('toddler, age ' || to_char(age));
    elsif age between 6 and 12 then
      dbms_output.put_line('child, age ' || to_char(age));
    elsif age between 12 and 19 then
      dbms_output.put_line('teenager, age ' || to_char(age));
    elsif age between 20 and 39 then
      dbms_output.put_line('prime of life, age ' || to_char(age));
    elsif age between 40 and 64 then
      dbms_output.put_line('middle-aged, age ' || to_char(age));
    else
      dbms_output.put_line('senior citizen, age ' || to_char(age));
    end if;
  end loop;
end;
/
