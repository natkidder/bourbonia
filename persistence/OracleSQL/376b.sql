-- a fetch that pulls the largest profit goal by region and period
-- notice p_period and period are different datatypes.  That's OK--they're compatible.

declare
  p_period varchar2(10); p_region varchar2(20); p_yearstart date; p_profit_goal number(9,2);
begin
  select period, region, yearstart, profit_goal
  into p_period, p_region, p_yearstart, p_profit_goal
  from (
    select period, region, yearstart, profit_goal
    from profit_goals2
    order by profit_goal desc
    )
  where rownum < 2;
  dbms_output.put_line(p_period || '  ' || p_region);
  dbms_output.put_line(to_char(p_yearstart) || '  ' || to_char(p_profit_goal));
end;
/
