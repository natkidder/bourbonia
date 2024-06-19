/* 
illustrates use of global and local variables
myproc_x is global to the entire procedure
subfunc_x is local to each of the functions
the two subfunct_x's are not the same
*/

create or replace procedure myproc is
myproc_x number default 0;

function subfunc1 return number is
  subfunc_x number default 50;
begin
  subfunc_x := myproc_x + 3;
  return subfunc_x;
end;

function subfunc2 return number is
  subfunc_x number default 0;
begin
  subfunc_x := subfunc1;
  return subfunc_x;
end;

begin
  myproc_x := subfunc2;
  dbms_output.put_line('Initial value was 0');
  dbms_output.put_line('Final output is ' || myproc_x);
end;
/

exec myproc;
