-- give the validity of an object

select object_name, status
from user_objects
where object_name = 'PROFITS_VIEW'
/
