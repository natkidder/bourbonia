-- using the %type function with an equijoin

declare
  p_profit profits2.profit%type; p_headquarters regions2.headquarters%type;
begin
  select r.headquarters, p.profit
  into p_headquarters, p_profit
  from profits2 p, regions2 r
  where p.region = r.region
  and p.prod_type = 'garden' and p.period = 1
  and lower(r.region) = 'southeast';
   dbms_output.put_line(p_headquarters || '  ' || to_char(p_profit));
end;
/
