select p.rowid, p2.rowid, p.prod_type, p.profit, p.period, p.region
from profits2 p, profits2 p2
where p.rowid <> p2.rowid
and p.profit = p2.profit
and p.prod_type = p2.prod_type
and p.period = p2.period
and p.region = p2.region
/
