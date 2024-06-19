/*
demonstrating raising an exception in a sub-block to the exception section in the main block.
*/

declare
  e_zero_divide exception;
begin

  declare
    n number := 9;
    d number := 0;
    q number;
  begin
    q := n/d;
  exception
    when zero_divide then
      raise e_zero_divide;
  end;

  dbms_output.put_line('1st executable line after sub_block');
exception
  when e_zero_divide then
    dbms_output.put_line('division by zero somewhere');
end;
/
