/* illustrates a row-level trigger */

drop trigger update_golf_r2;
update golf_r2 set headquarters = upper(headquarters);


create or replace trigger update_golf_r2

-- MUST use before, not after
before insert or update of headcount on golf_r2
for each row 
-- new.xxx is non-bind outside the executable section
when (new.headcount > 5)

begin
  :new.headquarters := lower(:new.headquarters);
  dbms_output.put_line(:old.headquarters || ' was changed to ' ||
     :new.headquarters);
  insert into audit_trail (table_name, column_name, old_value, new_value)
  values ('golf_r2', 'headquarters', :old.headquarters, :new.headquarters);
end;
