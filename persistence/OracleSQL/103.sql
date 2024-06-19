select p.period, sum(p.profit)
from profits2 p, regions2 r
where p.region = r.region
group by p.period
having sum(p.profit) > 7000
/
