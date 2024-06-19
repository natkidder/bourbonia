declare
  -- nothing to declare
begin
  dbms_output.put_line(sqlcode() || '  ' || sqlerrm(sqlcode));
end;
/
