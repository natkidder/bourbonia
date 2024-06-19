/* index-by tables and their attributes */

declare
  type typ_itbl is table of number(9) index by binary_integer;
  idx_tbl typ_itbl;
  i number(5);
begin
  idx_tbl(-1) := -5;
  idx_tbl(0) := 0;
  idx_tbl(1) := 5;
  idx_tbl(2) := 10;
  idx_tbl(3) := 15;
  dbms_output.put_line('idx_tbl.count is ' || idx_tbl.count);
  i := idx_tbl.first;
  while i is not NULL loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', idx_tbl(i) is ' || to_char(idx_tbl(i)));
    i := idx_tbl.next(i);
  end loop;
  --
  -- what happens when we remove an element
  --
  idx_tbl.delete(2);
  dbms_output.put_line('when we delete element 2');
  i := idx_tbl.first;
  while i is not NULL loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', idx_tbl(i) is ' || to_char(idx_tbl(i)));
    i := idx_tbl.next(i);
  end loop;

-- the below cannot be used with index-by tables
---  idx_tbl.extend(3);
---  idx_tbl.trim(2);
  if idx_tbl.exists(2) then
    dbms_output.put_line('idx_tbl.exists(2) is TRUE');
  else
    dbms_output.put_line('idx_tbl.exists(2) is FALSE');
  end if;
  if idx_tbl.exists(3) then
    dbms_output.put_line('idx_tbl.exists(3) is TRUE');
  else
    dbms_output.put_line('idx_tbl.exists(3) is FALSE');
  end if;
  dbms_output.put_line('idx_tbl.count is ' || idx_tbl.count);
---
--- set an element to NULL
---
  idx_tbl(1) := NULL;
  i := idx_tbl.first;
  while i is not NULL loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', idx_tbl(i) is ' || to_char(idx_tbl(i)));
    i := idx_tbl.next(i);
  end loop;
  dbms_output.put_line('idx_tbl.count is ' || idx_tbl.count);
  
end;
