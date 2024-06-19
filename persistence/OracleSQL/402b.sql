/*
define and populate a table, then give the number of elements in that table.
*/

declare
  type team_type is table of varchar2(10);
  my_team team_type;
  my_cnt number(4);
begin
  my_team := team_type('SMITH','SOTO','JAMES','WILSON','HOWLETT','SANO');
  my_cnt := my_team.count;
  dbms_output.put_line('my team has a count of ' || to_char(my_cnt));
end;
/
