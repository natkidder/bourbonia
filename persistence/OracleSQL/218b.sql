-- updating a table's field to the value of a joined table's field

update regions2 r
set r.profit_goal = (
  select g.profit_goal
  from golf_regions g
  where r.region = g.region
  )
/
