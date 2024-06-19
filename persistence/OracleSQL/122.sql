select prod_type, profit
from (
  select prod_type, sum(profit) profit
  from profits2
  group by prod_type
  order by profit desc
  )
where rownum <= 2
/
