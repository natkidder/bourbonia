-- find the period/regions whose profits exceeded goals

select p.period, p.region, sum(p.profit)
from profits2 p
group by p.period, p.region
having (p.period, p.region) in (
  select g.period, g.region
  from profit_goals2 g
  where g.period < 3
  and sum(p.profit) > g.profit_goal
  )
/
