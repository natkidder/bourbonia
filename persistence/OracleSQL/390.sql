/*
Illustrates the different implicit cursor attributes in a select
*/

declare
  p_count number(5);
begin
  select count(rowid) into p_count
  from profits2
  where prod_type = 'paint';
  dbms_output.put_line('The number of table rows actually pulled was ' || 
       to_char(p_count));
  if sql%found then
    dbms_output.put_line('an implicit cursor was created');
  elsif sql%notfound then
    dbms_output.put_line('no implicit cursor was created');
  end if;
  if sql%isopen then
    dbms_output.put_line('cursor is opened and ready for use');
  end if;
  dbms_output.put_line('sql%rowcount is ' || to_char(sql%rowcount));
end;
/
