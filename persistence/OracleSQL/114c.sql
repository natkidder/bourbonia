-- find the minimum profit goal for each period
-- can also be done by a straightforward group by

select period, profit_goal
from profit_goals2 g
where (period, profit_goal) in (
  select period, min(profit_goal)
  from profit_goals2 g2
  group by period
  )
/
