select p.prod_type, p.region, p.period
from profits2 p, profits2 p2
where p.prod_type = p2.prod_type
and p.region = p2.region
and p.period = p2.period
and p.rowid != p2.rowid
/
