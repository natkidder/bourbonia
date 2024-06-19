column deptno format 099 wrap heading 'dept no.'
column ename format a9 wrap heading 'person'
column sal format $99,999 heading 'salary'
break on deptno skip 1
set underline =
compute count of ename on deptno
compute sum of sal on deptno
ttitle = 'XYZ Corp. HR'
btitle = '141.sql'
set pagesize 30

select deptno, ename, sal
from emp
order by deptno, ename
/

set pagesize 20
set underline +
