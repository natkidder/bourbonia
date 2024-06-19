/*
using the %rowtype datatype identifier
*/

declare
  p_ptype prod_types2%rowtype;
begin
  --
  -- golf_pt2 is a copy of prod_types2
  --
  select * into p_ptype
  from golf_pt2
  where prod_type = 'garden';
  dbms_output.put_line(p_ptype.prod_type || '  ' || p_ptype.depot_loc);
  dbms_output.put_line(p_ptype.prod_desc);
end;
/
