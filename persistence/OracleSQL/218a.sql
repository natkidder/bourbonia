-- updating a row from a single-row subquery

update employee set
lastname = (select ename from emp where empno = '7844')
where empid = '49392'
/
