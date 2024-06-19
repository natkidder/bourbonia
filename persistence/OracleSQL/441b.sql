/*
shows handling an error in a sub_block by raising it to the main block's exception section.
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
      raise;
  end;
  dbms_output.put_line('1st executable line after sub_block');
exception
  when zero_divide then
    dbms_output.put_line('division by zero in a block');
end;
/
