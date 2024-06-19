-- CAUTION: this doesn't necessarily work

declare
  type ttyp_tbl is table of emp%rowtype;
  t_emp ttyp_tbl;
begin
---  t_emp(1) := ttype_tbl(select * from emp where empno = 7844);
  select * into t_emp(1) from emp where empno = 7844;
end;
