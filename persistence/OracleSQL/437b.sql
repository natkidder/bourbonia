/*
using an unspecified handler
*/
declare
  cursor c_reg is select * from regions2;
  v_reg regions2%rowtype;
  e_hdcnt_null exception;
  v_sqlcode number(6);
  v_sqlerrm varchar2(65);
begin
  open c_reg;
-- can comm out or leave to toggle between the two error conditions;
  open c_reg;
  loop
    fetch c_reg into v_reg;
    exit when c_reg%notfound;
    if v_reg.headcount is null or v_reg.headcount = 0 then 
      raise e_hdcnt_null;
    end if;
  end loop;
  close c_reg;
exception
-- notice I can pass the rowtype record variable to the exception section
  when e_hdcnt_null then
    dbms_output.put_line(v_reg.region || ' has no headcount');
  when others then
    v_sqlcode := sqlcode;
    v_sqlerrm := substr(sqlerrm(sqlcode), 1, 65);
    dbms_output.put_line('Error ' || v_sqlcode || ', ' || v_sqlerrm 
        || ' has occurred');
end;
