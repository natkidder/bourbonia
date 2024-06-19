declare
  p_prod_type profits2.prod_type%type;
  p_yearstart profits2.yearstart%type default '1-jan-2002';
  p_period profits2.period%type default 2;
  p_region profits2.region%type;
  p_profit profits2.profit%type default 4000;
begin
  select region into p_region
  from regions2
  where headquarters = 'columbus';
  select prod_type into p_prod_type
  from prod_types2
  where prod_desc = 'paint, varnish, brushes, rollers';
  insert into profits2(prod_type, yearstart, period, region, profit) values
  (p_prod_type, p_yearstart, p_period, p_region, p_profit);
end;
/
