/* inserting into a nested table from a loop 
   needs tweaking
*/

declare
  type typ_reg_tbl is table of regions2%rowtype;
  v_reg_tbl typ_reg_tbl;
  cursor c_reg is select * from regions2;
  i number(5);
  j number(5) := 0;
begin
  for v_reg in c_reg loop
    v_reg_tbl := typ_reg_tbl(v_reg);
    j := j + 1;
  end loop;

  for i in v_reg_tbl.first..v_reg_tbl.last loop
    dbms_output.put_line(to_char(i) || 'th region is ' || v_reg_tbl(i).region);
  end loop;
end;
/
