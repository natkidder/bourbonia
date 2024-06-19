select sum(p.profit), p.region, p.period
from profits2 p
group by p.region, p.period
having sum(p.profit) < (
  select r.profit_goal
  from regions2 r
  where r.region = p.region
  )
/
