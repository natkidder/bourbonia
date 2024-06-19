/*
Illustrates the different implicit cursor attributes in a DML environment
*/

declare
  p_profit number(5) := 5000;
  p_count number(5);
begin
  commit;
  dbms_transaction.read_write();
  update golf_profits2 set profit = p_profit where prod_type = 'paint';
  --
  -- has no effect on the cursors for the above stmt
  --
  rollback; 
  --
  -- get the implicit cursor attributes
  --
  dbms_output.put_line('update golf_profits2 set profit = p_profit where prod_type = paint');
  if sql%found then
    dbms_output.put_line('an implicit cursor was created');
  elsif sql%notfound then
    dbms_output.put_line('no implicit cursor was created');
  end if;
  if sql%isopen then
    dbms_output.put_line('cursor is opened and ready for use');
  end if;
  dbms_output.put_line('sql%rowcount is ' || to_char(sql%rowcount));
  --
  -- count the number of rows selected
  --
  select count(rowid) into p_count
  from golf_profits2 where prod_type = 'paint';
  dbms_output.put_line('no. of rows with paint are ' || to_char(p_count));
end;
/
