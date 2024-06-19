select a.constraint_name, a.constraint_type, b.column_name, b.position
from user_constraints a, user_cons_columns b
where a.table_name = b.table_name
and lower(a.table_name) = '&tablename'
and b.position is not null
order by a.constraint_type, a.constraint_name, b.position
/
