/* using %type in fetching group data */

declare
  p_period profits2.period%type; p_yearstart profits2.yearstart%type;
  p_prod_type profits2.prod_type%type; p_profit profits2.profit%type;
begin
  select period, yearstart, prod_type, sum(profit)
  into p_period, p_yearstart, p_prod_type, p_profit
  from profits2
  group by period, yearstart, prod_type
  having period = 1 and lower(prod_type) = 'garden';
  dbms_output.put_line(to_char(p_period) || '  ' || to_char(p_yearstart));
  dbms_output.put_line(p_prod_type || '  ' || to_char(p_profit));
end;
/
