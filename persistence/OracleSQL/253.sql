-- seeing which columns are updatable (ie. in the key-preserved table) in a view

select column_name, updatable
from user_updatable_columns
where table_name = 'GOLFVIEW'
/
