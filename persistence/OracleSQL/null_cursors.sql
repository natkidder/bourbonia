/* 
shows that the cursors found and notfound properties are neither TRUE nor FALSE, but NULL before the first fetch.  By the way, c1%found = NULL won't work.
*/

declare
  cursor c1 is select * from regions2;
  v1 regions2%rowtype;
begin
  open c1;
  if c1%isopen then
    dbms_output.put_line('cursor is open');
  end if;
  if c1%found is null then
    dbms_output.put_line('cursor found is null');
  end if;
  if c1%notfound is null then
    dbms_output.put_line('cursor not found is null');
  end if;
  loop
    fetch c1 into v1;
    exit when c1%notfound;
  end loop;
  close c1;
end;
/
