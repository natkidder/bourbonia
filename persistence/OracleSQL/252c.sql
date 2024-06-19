-- create complex view, particularly to test key preservation for updating

create or replace view v_profit_regions as (
  select p.period, p.profit, r.headquarters
  from golf_profits2 p, golf_regions2 r
  where p.region = r.region
  );
