select p.rowid, p.period, p.region, p.prod_type, p.profit
from profits2 p
where p.profit = (
  select min(p2.profit)
  from profits2 p2
  where nvl(p.period,99) = nvl(p2.period,99)
  )
/
