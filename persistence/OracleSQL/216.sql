-- insert via a subquery

insert into golf_profits2 (period, prod_type, region, headquarters)
(select p.period, p.prod_type, p.region, r.headquarters
 from profits2 p, regions2 r
 where p.region = r.region)
/
