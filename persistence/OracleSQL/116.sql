-- pulling max profit from a region, even from a profit line with a NULL region

select p.rowid, p.region, p.profit
from profits2 p
where p.profit = (
  select max(p2.profit)
  from profits2 p2
  where nvl(p.region,'none') = nvl(p2.region,'none')
  )
/
