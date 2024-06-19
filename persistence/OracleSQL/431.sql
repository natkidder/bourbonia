/*
example of a user-defined constraint, ensuring headcount doesn't fall below zero.  Opposes 431b
*/
set echo off
alter table regions2 drop constraint ck_headcount;
select region, headcount from regions2 order by region;

declare
  e_no_hdcnt exception;
  cursor c_reg is select region, headcount from regions2;
  type rtyp_reg is record (
    v_region regions2.region%type,
    v_headcount regions2.headcount%type);
  v_reg rtyp_reg;
  v_bad_reg regions2.region%type;
begin
  open c_reg;
  loop
    fetch c_reg into v_reg;
    exit when c_reg%notfound;
    v_reg.v_headcount := v_reg.v_headcount - 3;
    if v_reg.v_headcount < 0 then
      v_bad_reg := v_reg.v_region;
      raise e_no_hdcnt;
    else
      update regions2 set headcount = v_reg.v_headcount
        where region = v_reg.v_region;
    end if;
  end loop;
  close c_reg;
  commit;
exception
  when e_no_hdcnt then
    dbms_output.put_line('headcount below zero for region ' || v_bad_reg);
    dbms_output.put_line('sqlcode is ' || sqlcode);
    dbms_output.put_line('sqlerrm(sqlcode) is ' || sqlerrm);
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
alter table regions2 add constraint ck_headcount check (headcount >= 0);
set echo on
