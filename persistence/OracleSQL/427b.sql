declare
  cursor c1 is
    select t1.deptno, dname, "STAFF"
    from dept t1, (select deptno, count(*) "STAFF"
                   from emp group by deptno) t2
    where t1.deptno = t2.deptno and "STAFF" >= 5;
begin
  for v1 in c1 loop
    dbms_output.put_line(v1.deptno);
  end loop;
end;
/
