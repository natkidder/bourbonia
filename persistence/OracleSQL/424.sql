/*
illustrating the FOR UPDATE clause.  Opposes 424b.
*/
set echo off
select region, headcount from regions2 order by region;

declare
  cursor c_reg is 
    select region, headcount from regions2 
    for update;
begin
  for v_reg in c_reg loop
    if v_reg.region like 'north%' then v_reg.headcount := v_reg.headcount + 1;
      elsif v_reg.region like 'south%' then v_reg.headcount := 
           v_reg.headcount + 2;
    end if;
--
-- 'current of c_reg' is all you need 'cause that directs you to the current 
-- cursor
--
    update regions2 set headcount = v_reg.headcount
      where current of c_reg;
  end loop;
  commit;
end;
/

column v_reg.region format a15
column v_reg.headcount format a10
declare
  cursor c_reg is select * from regions2 order by region;
begin
  for v_reg in c_reg loop
    dbms_output.put_line(v_reg.region || '  ' || v_reg.headcount);
  end loop;
  commit;
end;
/
set echo on
