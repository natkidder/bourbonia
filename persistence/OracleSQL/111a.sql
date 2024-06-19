select profit, region, period, prod_type
from profits2
where exists (
  select region
  from regions2
  where profits2.region = regions2.region
  and regions2.headquarters = 'albany'
  )
/
