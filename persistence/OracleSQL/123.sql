select prod_type, period, r.headquarters, profit
from profits2 p, (
  select region, headquarters
  from regions2
  ) r
where p.region (+) = r.region
and prod_type = '&product'
/
