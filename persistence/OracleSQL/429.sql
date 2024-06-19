/*
invokes the different predefined exceptions.  NOTE: some of these don't work
*/
set echo off
--
-- invalid cursor
--
declare
  cursor c_reg is select * from regions2;
begin
  close c_reg;
exception
  when invalid_cursor then
    dbms_output.put_line('you cant close an unopened cursor');
end;
/
--
-- cursor already open
--
declare
  cursor c_profit is select prod_type, region, period from profits2;
begin
  open c_profit;
  open c_profit;
exception
  when cursor_already_open then
    dbms_output.put_line('the cursor was already open');
end;
/
--
-- primary key violation
--
-- this ASSUMES that paint is already a product type and prod_type is the pk
--
declare
  -- nothing to declare
begin
  insert into prod_types2 (prod_type, prod_desc, depot_loc) values
    ('paint','paints, varnishes and supplies','kalamazoo');
  insert into prod_types2 (prod_type, prod_desc, depot_loc) values
    ('paint','paints, varnishes and supplies','kalamazoo');
exception
  when dup_val_on_index then
    dbms_output.put_line ('duplicate entry on unique or primary key');
end;
/
--
-- unique index violation
--
-- ASSUMES that headquarters is a unique key and there's already an 'albany'
--
declare
  -- nothing to declare
begin
  update regions2 set headquarters = 'albany'
    where region = 'southeast';
exception
  when dup_val_on_index then
    dbms_output.put_line ('duplicate entry on unique or primary key');
end;
/
--
-- no data found
--
declare
  cursor c_reg(p_headquarters varchar) is 
    select * from profits2 where region = (
      select region from regions2
      where headquarters = p_headquarters
      ) for update;
begin
  for v_reg in c_reg('downhome') loop
    dbms_output.put_line(v_reg.region);
    update profits2 set profit = profit + 1
      where current of c_reg;
  end loop;
exception
  when no_data_found then
    dbms_output.put_line('no data found');
end;
/
