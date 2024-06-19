set echo off
/*
invokes the different predefined exceptions.  NOTE: some of these don't work
*/
--
-- more rows than expected
-- NOTE: this predefined exception fails to invoke
--
declare
  v_profits2 profits2%rowtype;
begin
  select * into v_profits2 from profits2
    where period = 1;
exception
  when too_many_rows then
    dbms_output.put_line('multiple rows assigned from query when one expected');
end;
/
--
-- division by zero
--
declare
  v_zero constant number := 0;
  cursor c_profit_head is 
    select profit/v_zero profit_head from profits2;
begin
  for v_profit_head in c_profit_head loop
    dbms_output.put_line(v_profit_head.profit_head);
  end loop;
exception
  when zero_divide then
    dbms_output.put_line('An attempt was made to divide by zero');
end;
/
--
-- data type (rowtype) mismatch
--
declare
  v_profits2 profits2%rowtype;
  v_regions2 regions2%rowtype;
---  v_period regions2.headcount%type;
begin
  select * into v_profits2 from profits2;
  v_regions2 := v_profits2;
---  select headquarters into v_period from regions2
---    where region = 'midwest';
exception
  when rowtype_mismatch then
    dbms_output.put_line('the rows dont match');
  when invalid_number then
    dbms_output.put_line('invalid number');
end;
/
--
-- invalid number
-- this exception fails to invoke
--
declare
  v_reg number;
begin
  v_reg := 'five';
exception
  when invalid_number then
    dbms_output.put_line('invalid assigning an alphanumeric to a numeric');
end;
/
set echo on
