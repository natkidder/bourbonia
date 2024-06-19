-- determine if fields linked through relational constraints have the same name
-- also demonstrates a 3-way inner join
-- you use separate aliases for all_cons_columns because you are trying to get
--   the column name involved in child table, and then the column name 
--   involved in the parent table, which may be in a separate row in 
--   all_cons_columns

select a.table_name, b.column_name, c.table_name, c.column_name
from all_constraints a, all_cons_columns b, all_cons_columns c
where a.constraint_name = b.constraint_name
and a.r_constraint_name = c.constraint_name
/
