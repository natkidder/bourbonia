/*
declare a record and then populate it via a fetch
*/

declare
  type t_prod_type is record (
    p_prod_type prod_types2.prod_type%type,
    p_prod_desc prod_types2.prod_desc%type,
    p_depot_loc prod_types2.depot_loc%type
    );
  -----------
  p_ptypes t_prod_type;
  p_ptypes2 t_prod_type;
  c_prod_type constant prod_types2.prod_type%type := 'garden';
  -----------
begin
  select prod_type, prod_desc, depot_loc
  into p_ptypes.p_prod_type, p_ptypes.p_prod_desc, p_ptypes.p_depot_loc
  from prod_types2
  where prod_type = c_prod_type;
  ----------
  dbms_output.put_line(p_ptypes.p_prod_type || '  ' || p_ptypes.p_depot_loc);
  dbms_output.put_line(p_ptypes.p_prod_desc);
  ----------
  p_ptypes2 := p_ptypes;
  dbms_output.put_line(p_ptypes2.p_prod_type || '  ' || p_ptypes2.p_depot_loc);
  dbms_output.put_line(p_ptypes2.p_prod_desc);
end;
/
