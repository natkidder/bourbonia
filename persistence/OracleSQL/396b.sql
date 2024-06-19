/*
sub-record example
*/

declare
  type t_supplier is record (
    p_name varchar2(20),
    p_city varchar2(20),
    p_state char(2),
    p_zip char(5)
    );
  type t_prod_type is record (
    p_prod_type prod_types2.prod_type%type,
    p_prod_desc prod_types2.prod_desc%type,
    p_depot_loc prod_types2.depot_loc%type,
    p_supplier t_supplier
    );
  p_prod_types t_prod_type;
begin
  p_prod_types.p_prod_type := 'lumber';
  p_prod_types.p_prod_desc := 'plain, wolmanized';
  p_prod_types.p_depot_loc := 'dayton';
  p_prod_types.p_supplier.p_name  := 'weyerhauser';
  p_prod_types.p_supplier.p_city  := 'alpharetta';
  p_prod_types.p_supplier.p_state := 'GA';
  p_prod_types.p_supplier.p_zip   := '33953';
end;
/
