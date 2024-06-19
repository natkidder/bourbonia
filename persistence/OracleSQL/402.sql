/*
example of a constructor
*/

declare
  type team_type is table of varchar2(10);
  my_team team_type;
begin
/*
Constructor below is called team_type.  It has to be called that because that is the table type property of my_team.
*/
  my_team := team_type('SMITH','SOTO','JAMES','WILSON','HOWLETT','SANO');
end;
/
