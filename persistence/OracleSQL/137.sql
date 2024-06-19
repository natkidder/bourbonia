column profit format $99,999.99 heading 'Earnings'
set underline *
column prod_type format a9 heading 'Product|Class'
column headquarters format a15 heading 'Head|Quarters'
column comments wrap on format a15

select prod_type, period, headquarters, profit, comments
from profits2 p, regions2 r
where p.region = r.region (+)
/
