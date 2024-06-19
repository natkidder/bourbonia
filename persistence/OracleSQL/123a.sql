------------
-- instantiate a variable, have the user enter it,
-- run the sql script and destroy it
------------
accept var_prod_type prompt 'Enter product type --> '

select p.profit, p.prod_type, p.period, p.region
from profits2 p, (
  select region
  from regions2 r
  where reg_head like '%i%'
  ) r
where p.region = r.region and
prod_type = '&var_prod_type'

undefine var_profit
/
