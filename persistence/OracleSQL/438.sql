/*
procedure illustrating use of raise_application_error in a procedure
NOTE: this is called from 438b
*/

create or replace procedure raise_headcount(p_region in varchar2, p_amount in number) is
  v_curr_hdcnt number;
  e_hdcnt_null exception;
  v_sqlcode number(6);
  v_sqlerrm varchar(60);
begin
  select headcount into v_curr_hdcnt from golf_r2 where region = p_region;
  if v_curr_hdcnt is null then
    raise e_hdcnt_null;
  else
    update golf_r2 set headcount = headcount + p_amount 
      where region = p_region;
  end if;
exception
  when e_hdcnt_null then
    raise_application_error(-20853,'Headcount for ' || p_region || ' is null',
          TRUE);
  when others then
    v_sqlcode := sqlcode;
    v_sqlerrm := substr(sqlerrm,1,60);
    dbms_output.put_line('Error ' || v_sqlcode || ': ' || v_sqlerrm);
end;
/

accept v_reg prompt 'Enter region: '
accept v_num number prompt 'Enter headcount raise: '
---variable v_region varchar2(20) 
---variable v_raise number 
---:v_region = v_reg;
---:v_raise  = v_num;
declare
begin
  raise_headcount('&v_reg', &v_num);
exception
  when others then null;
end;
