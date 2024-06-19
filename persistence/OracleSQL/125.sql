set define #
define area = 'southeast'

select stddev(profit), avg(profit)
from profits2
where region = '#area'
group by region;

undefine area
