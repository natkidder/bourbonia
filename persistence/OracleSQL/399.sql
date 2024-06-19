/* assigning a dynamic-datatype record to a user-defined record, even though
   the two records are technically unequal
*/
declare
  type rtyp_pt is record (
    v_prod_type varchar2(20),
    v_prod_desc varchar2(200),
    v_depot_loc varchar2(20),
    v_total_profit number(15,2)
    );
  v_pt rtyp_pt;
  v_pt2 prod_types2%rowtype;
begin
  select prod_type, prod_desc, depot_loc, total_profit into
   v_pt2.prod_type, v_pt2.prod_desc, v_pt2.depot_loc, v_pt2.total_profit
    from prod_types2 where prod_type = 'paint';
  v_pt := v_pt2;
end;
/
