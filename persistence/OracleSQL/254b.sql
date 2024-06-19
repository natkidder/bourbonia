create or replace view v1 as (
  select p1.prod_type, p1.profit, p2.prod_desc, p2.depot_loc
  from golf_p2 p1, golf_pt2 p2
  where p1.prod_type = p2.prod_type
  )
/
