-- illustrates the use of the 'set define' command

set define ?
select region, profit_goal
from profit_goals2
where region = '?var_region'
/
set define &
