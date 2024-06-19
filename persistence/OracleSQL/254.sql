-- determine which columns are updatable in a plain view

select column_name, updatable
from user_updatable_columns
where table_name = 'EMP_DEPT_VIEW'
/
