set define &
accept pd prompt 'Enter the period (1-3): '

select variance(profit), stddev(profit), avg(profit)
from profits2
where period = &pd
group by period;
