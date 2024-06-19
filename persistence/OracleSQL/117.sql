select p.prod_type, p.period, p.region, p.profit
from profits2 p
where p.profit = (
  select min(profit)
  from profits2 p2
  where nvl(p.region,'somewhere') = nvl(p2.region,'somewhere')
  )
/
