select p.region, p.profit
from profits2 p, (
  select region, max(profit) profit
  from profits2
  group by region
  ) p3
where p.region = p3.region
and p.profit = p3.profit
/
