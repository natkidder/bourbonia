/*
example of an internal exception (1427)
*/
declare
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
    when overly_rows then
      dbms_output.put_line('too many rows selected');
      dbms_output.put_line(sqlcode || ', ' || sqlerrm(sqlcode));
  end;
  dbms_output.put_line('just after the sub-block ends');
exception
  when others then 
    dbms_output.put_line('in the callers exception section');
end;
