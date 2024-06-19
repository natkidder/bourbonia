/*
running a stored procedure from an anonymous programs.  Works hand-in-glove with 438
*/
accept v_region prompt 'enter region: '
accept v_hc_raise number prompt 'enter number to raise headcount by: '
declare
  v_region golf_r2.region%type := '&v_region';
  v_headcount golf_r2.headcount%type := &v_hc_raise;
begin
  raise_headcount(v_region, v_headcount);
end;
/
