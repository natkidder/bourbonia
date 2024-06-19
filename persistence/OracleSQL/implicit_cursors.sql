declare
  v_reg varchar2(20);
begin
  select region into v_reg from regions2 where headquarters = 'macon';
  if sql%found then dbms_output.put_line('found'); end if;
  if sql%notfound then dbms_output.put_line('not found'); end if;
  if not sql%isopen then dbms_output.put_line('not open'); end if;
  dbms_output.put_line(to_char(sql%rowcount));
end;
/
