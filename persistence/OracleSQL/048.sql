/* example of decode */

select period, decode(period, 1, 'first', 2, 'second', 'later'), region
from golf_profits2
/
