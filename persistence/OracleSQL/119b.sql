select p.prod_type, d.depot_loc, sum(p.profit)
from profits2 p, (
  select prod_type, depot_loc
  from prod_types2 d
  where depot_loc in ('cleveland', 'dayton')
  ) d 
where p.prod_type = d.prod_type
group by p.prod_type, d.depot_loc
/
