/*
illustrating the table type.  Need it to be an index table for this example
*/

declare
  type team_type is table of varchar2(10)
    index by binary_integer;
  my_team team_type;
begin
  for x in 1..6 loop
    if x = 1 then
      my_team(x) := 'SMITH';
    elsif x = 2 then
      my_team(x) := 'SOTO';
    elsif x = 3 then
      my_team(x) := 'JAMES';
    elsif x = 4 then
      my_team(x) := 'WILSON';
    elsif x = 5 then
      my_team(x) := 'HOWLETT';
    elsif x = 6 then
      my_team(x) :='SANO';
    end if;
  end loop;
end;
/
