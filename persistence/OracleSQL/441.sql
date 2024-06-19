/*
shows that a handled sub-block exception goes strainght to the callers main block 
*/

declare
begin
  declare
    n number := 9;
    d number := 0;
    q number;
  begin
    q := n/d;
  exception
    when zero_divide then
      null;
  end;
  dbms_output.put_line('1st executable line after sub_block');
exception
  when others then
    dbms_output.put_line('a mistake has occurred');
end;
/
