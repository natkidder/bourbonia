select constraint_name, table_name from user_constraints
where lower(table_name) in ('profits','prices','product_types','unit_sales')
order by table_name, constraint_name
/
