/*
example of a user-defined constraint, ensuring headcount doesn't rise above ten.  Opposes 431b
*/
set echo off
select region, headcount from regions2 order by region;

declare
  e_high_hcnt exception;
  cursor c_reg is select * from regions2;
  v_reg regions2%rowtype;
  v_bad_reg regions2.region%type;
begin
  open c_reg;
  loop
    fetch c_reg into v_reg;
    exit when c_reg%notfound;
    v_reg.headcount := v_reg.headcount + 3;
    if v_reg.headcount > 10 then
      v_bad_reg := v_reg.region;
      raise e_high_hcnt;
    else
      update regions2 set headcount = v_reg.headcount
        where region = v_reg.region;
    end if;
  end loop;
  close c_reg;
  commit;
exception
  when e_high_hcnt then
    dbms_output.put_line('headcount above 10, for region ' || v_bad_reg);
end;
/

declare
  cursor c_reg is select region, headcount from regions2 order by region;
begin
  for v_reg in c_reg loop
    dbms_output.put_line(v_reg.region || '  ' || v_reg.headcount);
  end loop;
end;
/    

set echo on
