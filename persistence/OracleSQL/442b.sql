/*
shows encapsulating an error inside a subblock so the main block doesn't have to deal with it, and the GOTO statement to exit a sub-block to a main block
set one or more headcounts in region2 to null to invoke an error in the main block.
*/

declare
  e_null_hdcnt exception;
  v_sqlcode number;
  v_sqlerrm varchar2(70);
  cursor c_reg is select * from regions2 order by region;
  v_headq varchar2(20) default 'Juneau';
begin

  -- sub_block
  declare
  begin
    select headquarters into v_headq
      from regions2
      where region = 'Alaska';
  exception
    when no_data_found then 
      goto main_loop;
  end;

  dbms_output.put_line('sub-block ran without exception');
<<main_loop>>

  for v_reg in c_reg loop
    if v_reg.headcount is null then
      raise e_null_hdcnt;
    else 
      dbms_output.put_line(v_reg.region || '  ' || v_reg.headcount);
    end if;
  end loop;
  dbms_output.put_line('Alaska headquarters would be ' || v_headq);

exception
  when e_null_hdcnt then
    v_sqlcode := sqlcode();
    v_sqlerrm := substr(sqlerrm(sqlcode),1,70);
    dbms_output.put_line('Error: ' || v_sqlcode || ', ' || v_sqlerrm);
  when others then
    dbms_output.put_line('Unspecified error');
end;
/
