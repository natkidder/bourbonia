/*
shows the different attributes and operations (properties and methods) of nested tables (collections)
*/

set serveroutput on size 5000;
--- spool nested_tables.out

declare
  type num_array is table of number(3);
  t_array num_array;
  v_count number(3); v_stat2 number(3);
  i number(3); -- counter through the nested table elements
begin
  --
  -- set the nested table
  --
  t_array := num_array(10,20,30,40,50,60,70,80,90,100,110,120,130,140,150);
  --
  -- count the nested table
  --
  dbms_output.put_line('counting the nested table');
  v_count := t_array.count;
  dbms_output.put_line('initial table count is ' || to_char(v_count));
  if t_array.exists(v_count) then
    dbms_output.put_line('there are at least ' || to_char(v_count) ||
         ' elements in the nested table');
  else
    dbms_output.put_line('there are fewer than ' || to_char(v_count) ||
         ' elements in the nested table');
  end if;
  if t_array.exists(v_count+1) then
    dbms_output.put_line('there are at least ' || to_char(v_count+1) ||
         ' elements in the nested table');
  else
    dbms_output.put_line('there are fewer than ' || to_char(v_count+1) ||
         ' elements in the nested table');
  end if;
  --
  -- go through the nested table from beginning to end
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward through the nested table');
  i := t_array.first;
  while i is not NULL loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.next(i);
  end loop;
  --
  -- go through the nested table from end to beginning
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting backward through the nested table');
  i := t_array.last;
  loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.prior(i);
    exit when i = t_array.first;
  end loop;
  dbms_output.put_line('i is ' || to_char(i) ||
       ', t_array(i) is ' || to_char(t_array(i)));
  ---
  --- trim the nested table
  ---
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the nested table has had ' || 
       '3 elements trimmed');
  t_array.trim(3);
  for i in t_array.first..t_array.last loop
    dbms_output.put_line('i is ' || to_char(i) || 
         ', t_array(i) is ' || to_char(t_array(i)));
  end loop;
  --
  -- extend the nested table
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the nested table has had ' || 
       '2 elements extended');
  t_array.extend(2);
  i := t_array.first;
  loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', t_array(i) is ' || to_char(t_array(i)));
    i:= t_array.next(i);
    if i = t_array.last then exit;
    end if;
  end loop;
  dbms_output.put_line('i is ' || to_char(i) ||
       ', t_array(i) is ' || to_char(t_array(i)));
  --
  -- delete 1 element from the nested table
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the nested table has had ' || 
       'the 7th element deleted');
  t_array.delete(7);
  i := t_array.first;
  -- this looping structure ensures it covers every element of the array
  loop
    dbms_output.put_line('i is ' || to_char(i) || 
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.next(i);
    exit when i = t_array.last;
  end loop;
  dbms_output.put_line('i is ' || to_char(i) ||
       ', t_array(i) is ' || to_char(t_array(i)));
  --
  -- delete 3 elements from the nested table
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the nested table has had ' || 
       'the 3rd-5th element deleted');
  t_array.delete(3,5);
  i := t_array.first;
  loop
    dbms_output.put_line('i is ' || to_char(i) || 
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.next(i);
    exit when i = t_array.last;
  end loop;
  dbms_output.put_line('i is ' || to_char(i) ||
       ', t_array(i) is ' || to_char(t_array(i)));
  --
  -- destroy all!!
  --
  t_array.delete;
---  dbms_output.put_line('check nested_tables.out for the complete list');
end;
---spool out;
/
