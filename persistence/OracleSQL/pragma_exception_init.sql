/*
example of an internal exception (1427)
*/
declare
  overly_rows exception;
begin
  declare
    overly_rows exception;
    pragma exception_init(overly_rows,-00001427);
    cursor c_profit is
      select period, yearstart, prod_type, region from profits2
      where region = (
        select region from regions2
        where headquarters like '%a%'
        );
  begin
    for v_profit in c_profit loop
      dbms_output.put_line(v_profit.prod_type);
    end loop;
  exception
--- you can comment out these two lines to force the parents' exception
--- handler to handle the exception
    when overly_rows then
      dbms_output.put_line('too many rows selected');
      raise;
    when zero_divide then null;
  end;
  dbms_output.put_line('just after the sub-block ends');
exception
  when overly_rows then
    dbms_output.put_line('parent: too many rows selected');   
  when others then 
    dbms_output.put_line('in the callers exception section');
end;
