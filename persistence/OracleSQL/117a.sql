select p.prod_type, p.period, p.region, p.profit
from profits2 p
where p.profit in
  (
  select max(profit)
  from profits2 p2
  where nvl(p.region,'none') = nvl(p2.region,'none')
  )
/
