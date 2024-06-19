-- updating a table using subqueries

update prod_types2 pt set
total_profit = (
  select sum(profit)
  from profits2 pp
  where pp.prod_type = pt.prod_type
  group by prod_type
  );
