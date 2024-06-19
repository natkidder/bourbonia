-- illustrating declaring a function inside a procedure as a sub-block

create or replace procedure proc_f_to_c is
c_degrees number default 0;

function f_to_c (f_degree in number) return number is
  c_degree number default 0;
begin
  c_degree := (f_degree - 32) * 5 / 9;
  return c_degree;
end;

begin
  c_degrees := f_to_c(50);
  dbms_output.put_line('current temperature is ' || c_degrees || ' celcius');
end;
/

execute proc_f_to_c;
