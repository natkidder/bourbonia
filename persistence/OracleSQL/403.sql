set serveroutput on size 5000

declare
  type num_array is table of number(3);
  t_array num_array;
  v_count number(3); v_stat2 number(3);
  i number(3); -- counter through the array elements
begin
  --
  -- set the array
  --
  t_array := num_array(10,20,30,40,50,60,70,80,90,100,110,120,130,140,150);
  --
  -- count the array
  --
  dbms_output.put_line('counting the array');
  v_count := t_array.count;
  dbms_output.put_line('initial table count is ' || to_char(v_count));
  if t_array.exists(v_count) then
    dbms_output.put_line('there are at least ' || to_char(v_count) ||
         ' elements in the array');
  else
    dbms_output.put_line('there are fewer than ' || to_char(v_count) ||
         ' elements in the array');
  end if;
  --
  -- go through the array from beginning to end
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward through the array');
  i := t_array.first;
  while i is not NULL loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.next(i);
  end loop;
  --
  -- go through the array from end to beginning
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting backward through the array');
  i := t_array.last;
  loop
    dbms_output.put_line('i is ' || to_char(i) ||
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.prior(i);
    exit when i = t_array.first;
  end loop;
  ---
  --- trim the array
  ---
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the array has had ' || 
       '3 elements trimmed');
  t_array.trim(3);
  for i in t_array.first..t_array.last loop
    dbms_output.put_line('i is ' || to_char(i) || 
         ', t_array(i) is ' || to_char(t_array(i)));
  end loop;
  --
  -- extend the array
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the array has had ' || 
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
  --
  -- delete 1 element from the array
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the array has had ' || 
       'the 7th element deleted');
  dbms_output.put_line('It might not list the null items at the end'); 
  t_array.delete(7);
  i := t_array.first;
  while i is not NULL loop
    dbms_output.put_line('i is ' || to_char(i) || 
         ', t_array(i) is ' || to_char(t_array(i)));
    i := t_array.next(i);
  end loop;
  --
  -- delete 3 elements from the array
  --
  dbms_output.put_line(' ');
  dbms_output.put_line('counting forward after the array has had ' || 
       'the 3rd-5th element deleted');
  t_array.delete(3,5);
  for i in t_array.first..t_array.last loop
    dbms_output.put_line('i is ' || to_char(i) || 
         ', t_array(i) is ' || to_char(t_array(i)));
  end loop;
end;
/
