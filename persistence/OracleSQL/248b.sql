-- example of a view created using 'with check option'
-- golf_profits2 is a copy of profits2

create or replace view v_profits2 as (
  select period, yearstart, region, prod_type
  from golf_profits2
  where period < 3)
with check option constraint ck_v_profits2
/
