declare
  cursor c_reg is select * from golf_r2;
begin
  for v_reg in c_reg loop
    if v_reg.headcount is null then
      raise_application_error(-20999,'rhinos are enormous',FALSE);
    end if;
  end loop;
end;
/
