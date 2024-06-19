set define ?
accept ptype prompt 'Enter product type: '
accept minprofit prompt 'Enter mininum average profit: '

select avg(profit), prod_type
from profits2
where prod_type = '?ptype'
group by prod_type
having avg(profit) > ?minprofit;

undefine ptype
undefine minprofit
set define &
