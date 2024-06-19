-- function block, showing global scope for conv1 & conv2

create or replace procedure proc_f_to_c is
c_degrees number default 0;
conv1 constant number := 5;
conv2 number default 9;

function f_to_c (f_degree in number) return number is
  c_degree number default 0;
begin
  c_degree := (f_degree - 32) * conv1 / conv2;
  return c_degree;
end;

begin
  c_degrees := f_to_c(50);
  dbms_output.put_line('Current temperature is ' || c_degrees || ' celcius');
end;
/

exec proc_f_to_c;
