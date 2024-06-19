/*
example of a cursor-for loop.  Opposes 418d.
*/
set echo off
select region, headcount from regions2 order by region;

declare
  cursor c_reg is select region, headcount from regions2;
begin
  commit;
  dbms_transaction.read_write;
  for v_reg in c_reg loop
    if v_reg.region like 'north%' then v_reg.headcount := v_reg.headcount + 1;
      elsif v_reg.region like 'south%' then 
           v_reg.headcount := v_reg.headcount + 2;
    end if;
    update regions2 set headcount = v_reg.headcount
      where region = v_reg.region;
  end loop;
  commit;
end;
/

declare
  cursor c_reg is select * from regions2 order by region;
begin
  dbms_transaction.read_only;
  for v_reg in c_reg loop
    dbms_output.put_line(v_reg.region || '  ' || to_char(v_reg.headcount));
  end loop;
  commit;
end;
/
set echo on
