/*
example of declare, open, fetch, close (ducks on fens cruise) for explicit cursors.  Undoes 412b.
 Name                          Null?    Type
 ---------------------------- -------- ------------
 REGION                        NOT NULL VARCHAR2(15)
 REG_HEAD                               VARCHAR2(20)
 HEADQUARTERS                           VARCHAR2(20)
 COMMENTS                               VARCHAR2(30)
 HEADCOUNT                              NUMBER(5)
 PROFIT_GOAL                            NUMBER(9,2)
*/

select region, headcount from regions2 order by region;

declare
  cursor c_reg is 
    select region, headcount from regions2;
  v_region regions2.region%type;
  v_headcount regions2.headcount%type;

begin
  open c_reg; -- auto-starts at the beginning of the memory block
  loop
    fetch c_reg into v_region, v_headcount;
    exit when c_reg%notfound;
    if v_region like 'north%' then v_headcount := v_headcount - 1;
      elsif v_region like 'south%' then v_headcount := v_headcount - 2;
    end if;
    update regions2 set headcount = v_headcount
      where region = v_region;
  end loop;
  close c_reg;
  commit;
end;
/

declare
  cursor c_reg is 
    select region, headcount from regions2 order by region;
  v_region regions2.region%type;
  v_headcount regions2.headcount%type;

begin
  open c_reg;
  loop
    fetch c_reg into v_region, v_headcount;
    if c_reg%notfound then exit;  end if;
    dbms_output.put_line(v_region || '  ' || to_char(v_headcount));
  end loop;
  close c_reg;
end;
/
