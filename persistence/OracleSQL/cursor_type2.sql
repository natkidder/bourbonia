/*
illustrating fetching cursors into rowtype variables.  Opposes 413d
*/

select region, headcount from regions2 order by region;

declare
  cursor c_reg is select * from regions2;
  t_reg c_reg%rowtype;
begin
  open c_reg;
  loop
    fetch c_reg into t_reg;
    exit when c_reg%notfound;
    if t_reg.region like 'north%' then t_reg.headcount := t_reg.headcount - 1;
      elsif t_reg.region like 'south%' then t_reg.headcount := t_reg.headcount - 2;
    end if;
    update regions2 set headcount = t_reg.headcount
      where region = t_reg.region;
  end loop;
  close c_reg;
  commit;
end;
/

declare
  cursor c_reg is select * from regions2 order by region;
  t_reg regions2%rowtype;
begin
  open c_reg;
  loop
    fetch c_reg into t_reg;
    exit when c_reg%notfound;
    dbms_output.put_line(t_reg.region || '  ' || to_char(t_reg.headcount));
    dbms_output.put_line('c_reg%rowcount = ' || c_reg%rowcount);
  end loop;
  close c_reg;
end;
/
