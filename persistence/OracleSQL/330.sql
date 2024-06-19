-- PL/SQL function example, which converts fahrenheit to celcius

create or replace function f_to_c(f_degrees in number)
return number is c_degrees number default 0;
  conv1 constant number := 32;
  conv2 number default 5;
  conv3 number := 9;
begin
  c_degrees := (f_degrees - conv1) * conv2 / conv3;
  return c_degrees;
end;
/
