select p.prod_type, p.profit
from (
  select prod_type, min(profit) profit
  from profits2
  group by prod_type
  order by profit 
  ) p
where rownum < 4;
/
