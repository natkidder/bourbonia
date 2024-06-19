/* illustrates and instead-of trigger.  The work only on views. */

-- recreate the view first
--
create or replace view v_golf_pt2 as (
  select p.period, p.region, p2.prod_desc, p.profit
  from golf_p2 p, golf_pt2 p2
  where p.prod_type = p2.prod_type
  );
--
-- recreate the trigger
--
create or replace trigger instead_of_golf_p2
instead of insert or update or delete on v_golf_pt2
begin
  dbms_output.put_line('insert or update or delete of golf_p2 substituted');
exception
  when no_data_found then null;  --- no reason to put this here
  when others then null;
end;
