/* predicates trigger */

create or replace trigger predicates_trigger
before insert or update or delete on golf_r2
begin
  if inserting then
    dbms_output.put_line('predicates_trigger: inserting record');
  elsif updating then
    dbms_output.put_line('predicates_trigger: updating record');
  elsif deleting then
    dbms_output.put_line('predicates_trigger: deleting record');
  end if;
end;
