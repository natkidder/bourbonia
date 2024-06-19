-- sample generic trigger on table emp;

create or replace trigger emp_trig_01
before delete on emp
begin
  null;
exception
  when others then null;
end;
/
