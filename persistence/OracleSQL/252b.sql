create or replace view golfview as (
  select p.region, headquarters, p.profit_goal
  from profit_goals2 p, regions2 r
  where p.region = r.region
  and (p.region, p.profit_goal) in (
    select region, max(profit_goal)
    from profit_goals2
    group by region
    )
  )
with check option
/
