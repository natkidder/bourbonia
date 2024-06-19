-- illustrating sequential processing
/* 
The null at the end is necessary, as a label must be followed by some kind of executable code.
*/

declare
  rownum number(9); /* we declare counter variables so we can declare
                      them outside the loop */
  desknum number(9);
  pencilnum number default 26; rownum2 number(9); desknum2 number(9); i number(2);
begin
  -- loop through all the rows at the top level
  for rownum in 1..6 loop
    -- loop through all the desks in the current row
    for desknum in 1..5 loop
      -- Mr. Garrison places a pencil on the desk
      pencilnum := pencilnum - 1;
      dbms_output.put_line('rownum = ' || to_char(rownum) || ', desknum = ' ||
           to_char(desknum) || ', pencilnum = ' || to_char(pencilnum));
      if pencilnum < 1 then
        rownum2 := rownum; desknum2 := desknum;
        goto out_of_pencils;
      end if;
    end loop;
  end loop;
  goto end_program;
  <<out_of_pencils>>
  dbms_output.put_line('Pencils ran out on row ' || to_char(rownum2) || ', desk ' ||
       to_char(desknum2));
  <<end_program>>
-- you need a null stmt here
  null;
end;
/
