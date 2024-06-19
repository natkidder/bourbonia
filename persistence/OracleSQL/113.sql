select prod_type, region, sum(profit)
from profits2
group by prod_type, region
having region in (
  select region
  from regions2
  where reg_head in ('smithers','fujimori','lakkaraju')
  )
and prod_type = 'garden'
/
