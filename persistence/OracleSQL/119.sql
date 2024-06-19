select p.prod_type, p.profit, r.headq, p.period
from profits2 p, (
  select region, upper(headquarters) headq
  from regions2
  where reg_head like '%j%'
  ) r
where p.region = r.region
order by p.prod_type, p.period
/
